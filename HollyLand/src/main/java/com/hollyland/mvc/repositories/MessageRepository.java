package com.hollyland.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hollyland.mvc.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

	List<Message> findAll();
}
