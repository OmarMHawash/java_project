package com.hollyland.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hollyland.mvc.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

	List<City> findAll();
}
