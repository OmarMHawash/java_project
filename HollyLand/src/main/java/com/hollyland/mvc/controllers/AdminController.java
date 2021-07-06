package com.hollyland.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hollyland.mvc.models.Admin;
import com.hollyland.mvc.models.City;
import com.hollyland.mvc.models.Image;
import com.hollyland.mvc.models.Message;
import com.hollyland.mvc.models.Village;
import com.hollyland.mvc.services.AdminService;

@Controller
public class AdminController {
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping("/admin")
	public String showAdminLoginPage(HttpSession session,
			Model model) {
		Long adminId = (Long) session.getAttribute("adminId");
		System.out.println("admin id: "+adminId);
		if(adminId != null)
			return "redirect:/showAdminDashboardPage";
		return "/admin/login.jsp";
	}
		
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public String login(@RequestParam(name="email") String email,
			@RequestParam(name="password") String password,
			@RequestParam(name="rememberMe", required=false) String rememberMe,
			HttpSession session,
			Model model) {
		System.out.println("email: "+email);
		System.out.println("password: "+password);
		boolean isAuthorized = this.adminService.isAuthorized(email, password);
		if(rememberMe == "true") {
			session.setAttribute("email", email);
			session.setAttribute("password", password);
		}
		if(isAuthorized) {
			Admin admin = this.adminService.getAdminByEmail(email);
			session.setAttribute("adminId", admin.getId());
			return "redirect:/showAdminDashboardPage";
		}else {
			model.addAttribute("errors", "email or password is incorrect!");
		return "/admin/login.jsp";
		}
	}
	
	@RequestMapping("/showAdminDashboardPage")
	public String showAdminDashboardPage(Model model) {
		List<City> cities = this.adminService.getCities();
		List<Village> villages = this.adminService.getVillages();
		List<Message> messages = adminService.getMessages();
		model.addAttribute("cities", cities);
		model.addAttribute("villages", villages);
		model.addAttribute("messages", messages);

		return "admin/adminDashboard.jsp";
	}
	
	@RequestMapping("/delete_message/{id}")
	public String deleteMessage(@PathVariable(value="id")Long id) {
		adminService.deleteMsg(id);
		return "redirect:/showAdminDashboardPage";
	}
	@RequestMapping("/createVillage")
	public String addewVillage(@ModelAttribute("village") Village v,Model model) {
		List<City> cities = adminService.getCities();
		model.addAttribute("cities", cities);
		return "admin/addNewVillage.jsp";
	}
	
	@RequestMapping("/add_new_village")
	public String addNewVillage(@ModelAttribute("village") Village v,BindingResult isis) {
		if(isis.hasErrors()) {
			return "admin/addNewVillage.jsp";
		}else {
			adminService.createVillage(v);
			return "redirect:/showAdminDashboardPage";
		}
	}
	
	@RequestMapping("/edit_village/{id}")
	public String editVillage(@PathVariable(value="id")Long id ,
			Model model) {
		List<City> cities = adminService.getCities();
		model.addAttribute("cities", cities);
		model.addAttribute("village", adminService.findVillageById(id));
		return "admin/editVillage.jsp";
	}
	
	@RequestMapping("/edit_vill/{id}")
	public String editVil(@PathVariable(value="id")Long id,
			@RequestParam(value="name") String name,
			@RequestParam(value="space") double s,
			@RequestParam(value="population") int p,
			@RequestParam(value="description") String desc) {
//		int population = Integer.parseInt(p);
//		double space = Long.parseLong(s);

		adminService.updateVillage(id, name, s, p, desc);
		return "redirect:/showAdminDashboardPage";
		
	}
	@RequestMapping("/add_village_image/{id}")
	public String addewImage(@PathVariable(value="id")Long id,
			@ModelAttribute("image") Image i,Model model) {
		model.addAttribute("village",adminService.findVillageById(id));
		return "admin/addImage.jsp";
	}
	@RequestMapping("/delete_report/{id}")
	public String deleteReport(@PathVariable(value="id")Long id) {
		adminService.deleteReport(id);
		return "redirect:/showAdminDashboardPage";
	}
	@RequestMapping("/addImage")
	public String addNewImge(@ModelAttribute("image") Image i,BindingResult isis) {
		if(isis.hasErrors()) {
			return "admin/createImage.jsp";
		}else {
			adminService.createImage(i);
			return "redirect:/showAdminDashboardPage";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
}
