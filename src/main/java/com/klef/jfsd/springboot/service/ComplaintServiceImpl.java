package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.repository.ComplaintRepo;

@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	@Autowired
	private ComplaintRepo complaintrepo;
	
	@Override
	public long complaintcount() {
		return complaintrepo.count();
	}
	
	@Override
	public String addcomplaint(Complaint c) {
		 complaintrepo.save(c);
		 return "Complaint Added Successfully";
	}
	
	@Override
	public List<Complaint> viewcomplaints() {
		return complaintrepo.findAll();
	}
	
	@Override
	public Complaint viewcomplaintbyid(int id) {
		return complaintrepo.findById(id).get();
	}
	
}
