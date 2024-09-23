package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Handler;
import com.klef.jfsd.springboot.model.User;

@Repository
public interface HandlerRepo extends JpaRepository<Handler, Integer> {
	@Query("select h from Handler h where h.email=?1 and h.password=?2")
	public Handler checkhandlerlogin(String email,String password);
	
	@Query("select h from Handler h where id=?1")
	public Handler findgrp(int id);
}
