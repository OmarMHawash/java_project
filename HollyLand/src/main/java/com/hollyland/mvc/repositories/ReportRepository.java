package com.hollyland.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hollyland.mvc.models.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long>{
	
	List<Report> findAll();
}
