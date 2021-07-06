package com.hollyland.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hollyland.mvc.models.Village;

@Repository
public interface VillageRepository extends CrudRepository<Village, Long>{
	
	List<Village> findAll();
}
