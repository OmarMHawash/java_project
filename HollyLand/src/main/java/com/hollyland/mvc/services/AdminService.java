package com.hollyland.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hollyland.mvc.models.Admin;
import com.hollyland.mvc.models.City;
import com.hollyland.mvc.models.Image;
import com.hollyland.mvc.models.Message;
import com.hollyland.mvc.models.Village;
import com.hollyland.mvc.repositories.AdminRepository;
import com.hollyland.mvc.repositories.CityRepository;
import com.hollyland.mvc.repositories.ImageRepository;
import com.hollyland.mvc.repositories.MessageRepository;
import com.hollyland.mvc.repositories.ReportRepository;
import com.hollyland.mvc.repositories.VillageRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	private final CityRepository cityRepository;
	private final ImageRepository imageRepository;
	private final MessageRepository messageRepository;
	private final ReportRepository reportRepository;
	private final VillageRepository villageRepository;
	
	public AdminService(AdminRepository adminRepository, CityRepository cityRepository,
			ImageRepository imageRepository, MessageRepository messageRepository,
			ReportRepository reportRepository, VillageRepository villageRepository) {
		this.adminRepository = adminRepository;
		this.cityRepository = cityRepository;
		this.imageRepository = imageRepository;
		this.messageRepository = messageRepository;
		this.reportRepository = reportRepository;
		this.villageRepository = villageRepository;
	}
	
	public boolean isAuthorized(String email, String password) {
		String passwordToBeChecked = password;
		Admin admin = getAdminByEmail(email);
		String realPassword = admin.getPassword();
		if(admin != null)
			if(passwordToBeChecked.equals(realPassword))
				return true;
		return false;
	}
	
	public Admin getAdminByEmail(String email) {
		List<Admin> admins = this.adminRepository.findByEmail(email);
		return admins.get(0);
	}
	
	public void createAdmin(Admin admin) {
		this.adminRepository.save(admin);
	}
	
	public void createVillage(Village v) {
		this.villageRepository.save(v);
	}
	
	public void createImage(Image i) {
		this.imageRepository.save(i);
	}
	
	public City findCityById(long id) {
		City c = cityRepository.findById(id).orElse(null);
		return c;
	}
	
	public Village findVillageById(long id) {
		Village v = villageRepository.findById(id).orElse(null);
		return v;
	}
	
	public Village updateVillage(Long id, String name, double space, int population, String description) {
        if(findVillageById(id) != null) {
        	Village v = findVillageById(id);
        	v.setName(name);
        	v.setSpace(space);
        	v.setPopulation(population);
        	v.setDescription(description);
        	villageRepository.save(v);
        	return v;
        }
        return null;
        
	}
	
	public List<City> getCities(){
		return cityRepository.findAll();
	}
	
	public List<Village> getVillages(){
		return villageRepository.findAll();
	}
	public List<Message> getMessages(){
		return messageRepository.findAll();
	}
	public void deleteMsg(Long id) {
		messageRepository.deleteById(id);
	}
	
	public void deleteReport(Long id) {
		reportRepository.deleteById(id);
	}
	
}
