package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.Handler;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.AdminRepo;
import com.klef.jfsd.springboot.repository.ComplaintRepo;
import com.klef.jfsd.springboot.repository.HandlerRepo;
import com.klef.jfsd.springboot.repository.UserRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminrepo;
	
	@Autowired
	private ComplaintRepo complaintrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private HandlerRepo handlerRepo;
	
	@Override
	public Admin checkadminlogin(String username, String password) {
		return adminrepo.checkadminlogin(username, password);
	}

	@Override
	public long complaintcount() {
		return complaintrepo.count();
	}

	@Override
	public long userscount() {
		return userrepo.count();
	}

	@Override
	public long studentcount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long facultycount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Complaint> viewcomplaints() {
		return complaintrepo.findAll();
	}

	@Override
	public User finduserbyid(int id) {
		
		Optional<User> obj =  userrepo.findById(id);
		   
        if(obj.isPresent()){
          User u = obj.get();
          return u;
        }
        else{
          return null;
        }
		
	}

	@Override
	public List<User> viewallusers() {
		return userrepo.findAll();
	}
	
	@Override
	public List<Handler> viewallhandlers() {
		return handlerRepo.findAll();
	}

}
