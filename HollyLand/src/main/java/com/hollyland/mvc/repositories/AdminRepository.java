package com.hollyland.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hollyland.mvc.models.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{
	List<Admin> findByEmail(String email);
}
