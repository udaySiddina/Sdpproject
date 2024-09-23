package com.klef.jfsd.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.Handler;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.HandlerRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class HandlerServiceImpl implements HandlerService{

	@Autowired
	private HandlerRepo handlerrepo;
	
	@Autowired
	private ComplaintService complaintservice;
	
	@Override
	public String addhandler(Handler h) {
		 handlerrepo.save(h);
		 return "Handler Added Succesfully";
	}
	
	@Override
	public Handler checkhandlerlogin(String email, String password) {
		return handlerrepo.checkhandlerlogin(email, password);
	}

	@Override
	public List<Complaint> viewcomplaintsbycategory(String grptype) {
		List<Complaint> tlist = complaintservice.viewcomplaints();
		
		List<Complaint> list = new ArrayList<Complaint>();
		for(Complaint c: tlist) {
			if(c.getGrp()==grptype)
				list.add(c);
		}
		
		return list;
	}

	@Override
	public Handler findgrp(int id) {
		return handlerrepo.findgrp(id);
	}

}
