package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;

@Service
public interface ComplaintService {
	
	public long complaintcount();
	public String addcomplaint(Complaint c);
	public List<Complaint> viewcomplaints();
	public Complaint viewcomplaintbyid(int id);
	
}
