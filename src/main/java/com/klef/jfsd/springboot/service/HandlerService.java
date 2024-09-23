package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.Handler;
import com.klef.jfsd.springboot.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface HandlerService {

	public String addhandler(Handler h);
	public Handler checkhandlerlogin(String email, String password);
	public List<Complaint> viewcomplaintsbycategory(String grptype);
	public Handler findgrp(int id);

}
