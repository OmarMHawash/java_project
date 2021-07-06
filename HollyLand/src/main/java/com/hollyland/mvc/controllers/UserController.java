package com.hollyland.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hollyland.mvc.models.City;
import com.hollyland.mvc.models.Message;
import com.hollyland.mvc.models.Report;
import com.hollyland.mvc.models.Village;
import com.hollyland.mvc.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/")
	public String viewHome(@ModelAttribute("message") Message m) {
	return "home/homepage.jsp";
	}

	@RequestMapping("/city/{id}")
	public String viewNablus(@ModelAttribute("message") Message m,@PathVariable(value="id")Long id, Model model) {
		City city = userService.findCityById(id);
		model.addAttribute("city", city);
	
	return "home/homepage.jsp";
	}

	@RequestMapping("/village/{id}")
	public String viewVillage(@ModelAttribute("report") Report r,@PathVariable(value="id")Long id,Model model) {
		Village village = userService.findVillageById(id);
		model.addAttribute("village", village);
	return "home/village.jsp";
	}
	
	@RequestMapping("/add_report/{id}")
	public String addNewReport(@PathVariable(value="id")Long id,@ModelAttribute("report") Report r,BindingResult isis) {
		if(isis.hasErrors()) {
			return "home/village.jsp";
		}else {
			userService.createReport(r);
			return "redirect:/village/"+id;
		}
	}
	
	@RequestMapping("/add_message")
	public String addNewMessage(@ModelAttribute("message") Message m,BindingResult isis) {
		if(isis.hasErrors()) {
			return "home/homepage.jsp";
		}else {
			userService.createMessage(m);
			return "redirect:/";
		}
	}
}
