package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	
	public String adduser(User u);
	public User checkuserlogin(String email, String password);
	public long complaintcountbyuser(HttpServletRequest request);
	public List<Complaint> viewcomplaintsbyuser(HttpServletRequest request);
	public Complaint viewcomplaintbyid(int id);
	
}
