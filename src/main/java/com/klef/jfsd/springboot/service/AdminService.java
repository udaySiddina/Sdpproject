package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.Handler;
import com.klef.jfsd.springboot.model.User;

@Service
public interface AdminService {
	
	public Admin checkadminlogin(String username, String password);
	public long complaintcount();
	public List<Complaint> viewcomplaints();
	public List<User> viewallusers();
	public User finduserbyid(int id);
	public long userscount();
	public long studentcount();
	public long facultycount();
	public List<Handler> viewallhandlers();
}
