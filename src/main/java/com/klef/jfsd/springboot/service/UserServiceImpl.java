package com.klef.jfsd.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.ComplaintRepo;
import com.klef.jfsd.springboot.repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ComplaintRepo complaintrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private ComplaintService complaintservice;
	
	@Override
	public User checkuserlogin(String email, String password) {
		return userrepo.checkuserlogin(email, password);
	}

	@Override
	public String adduser(User u) {
		userrepo.save(u);
		return "Employee Added Successfully";
	}
	
	@Override
	public long complaintcountbyuser(HttpServletRequest request) {
		
		return viewcomplaintsbyuser(request).size();
	
	}
	
	@Override
	public List<Complaint> viewcomplaintsbyuser(HttpServletRequest request) {
		
		List<Complaint> tlist = complaintservice.viewcomplaints();
		
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		
		List<Complaint> list = new ArrayList<Complaint>();
		for(Complaint c: tlist) {
			if(c.getUserid()==id)
				list.add(c);
		}
		
		return list;
		
	}
	
	@Override
	public Complaint viewcomplaintbyid(int id) {
		return complaintrepo.findById(id).get();
	}
	
}
