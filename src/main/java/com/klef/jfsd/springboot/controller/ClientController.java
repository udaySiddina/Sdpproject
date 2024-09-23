package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.model.Handler;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.ComplaintRepo;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.ComplaintService;
import com.klef.jfsd.springboot.service.HandlerService;
import com.klef.jfsd.springboot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ComplaintService complaintservice;
	
	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private ComplaintRepo complaintrepo;
	
	@Autowired
	private HandlerService handlerservice;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("userlogin")
	public ModelAndView userlogin() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
		
	}
	
	@PostMapping("checkuserlogin")
	public ModelAndView checkuserlogin(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = userservice.checkuserlogin(email, password);
		
		if(u!=null) {
			mv.setViewName("home");
			
			HttpSession session = request.getSession();
			session.setAttribute("id", u.getId());
			session.setAttribute("name", u.getFname());
			
			long ccount = userservice.complaintcountbyuser(request);
			mv.addObject("ccount", ccount);
			
		}
		else {
			mv.addObject("message", "Login Failed");
			mv.setViewName("login");
		}
		
		return mv;
		
	}
	
	@PostMapping("checkhandlerlogin")
	public ModelAndView checkhandlerlogin(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Handler h = handlerservice.checkhandlerlogin(email, password);
		
		if(h!=null) {
			
			mv.setViewName("handlerhome");
			List<Complaint> clist = adminservice.viewcomplaints();
			mv.addObject("clist", clist);
			
			HttpSession session = request.getSession();
			session.setAttribute("id", h.getId());
			session.setAttribute("name", h.getFname());
			
		}
		else {
			mv.addObject("message", "Login Failed");
			mv.setViewName("handlerlogin");
		}
		
		return mv;
		
	}
	
	@GetMapping("handlerlogin")
	public ModelAndView handlerlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("handlerlogin");
		return mv;
	}
	
	@GetMapping("handlerhome")
	public ModelAndView handlerhome(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("handlerhome");
		List<Complaint> clist = adminservice.viewcomplaints();
		mv.addObject("clist", clist);
		return mv;
	}
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@GetMapping("viewcomplaintsbyuser")
	public ModelAndView viewcomplaints(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewcomplaintsuser");
		
		List<Complaint> clist = userservice.viewcomplaintsbyuser(request);
		
		System.out.println(clist);
		mv.addObject("clist", clist);
		
		return mv;
		
	}
	
	@GetMapping("viewcomplaintsbycategory")
	public ModelAndView viewcomplaintsbycategory(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		String grptype = handlerservice.findgrp(id).getGrptype();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewcomplaintsbycategory");
		
		List<Complaint> clist = handlerservice.viewcomplaintsbycategory(grptype);
		
		mv.addObject("clist", clist);
		
		return mv;
		
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin a = adminservice.checkadminlogin(username, password);
		
		if(a!=null) {
			mv.setViewName("adminhome");
			
			long ccount = adminservice.complaintcount();
			mv.addObject("ccount", ccount);
			long ucount = adminservice.userscount();
			mv.addObject("ucount", ucount);
			
		}
		else {
			mv.setViewName("adminlogin");
			mv.addObject("message", "Login Failed");
		}
		
		return mv;
		
	}
	
	@GetMapping("adduser")
	public ModelAndView adduser() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adduser");
		
		return mv;
	}
	
	@GetMapping("addhandler")
	public ModelAndView addhandler() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addhandler");
		
		return mv;
	}
	
	@PostMapping("handlerreg")
	public ModelAndView inserthandler(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		try {
			
			Handler h = new Handler();
			h.setFname( request.getParameter("fname") );
			h.setLname( request.getParameter("lname") );
			h.setGender( request.getParameter("gender") );
			h.setDob( request.getParameter("dob") );
			h.setEmail( request.getParameter("email") );
			h.setPassword( request.getParameter("password") );
			h.setGrptype( request.getParameter("grptype") );
			
			handlerservice.addhandler(h);
			
			mv.setViewName("adminhome");
			long ccount = adminservice.complaintcount();
			mv.addObject("ccount", ccount);
			long ucount = adminservice.userscount();
			mv.addObject("ucount", ucount);
			
			
		} 
		catch (Exception e) {
			mv.setViewName("addhandler");
		}
		
		return mv;
		
	}
	
	@PostMapping("userreg")
	public ModelAndView insertuser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		try {
			
			User u = new User();
			u.setFname( request.getParameter("fname") );
			u.setLname( request.getParameter("lname") );
			u.setGender( request.getParameter("gender") );
			u.setDob( request.getParameter("dob") );
			u.setEmail( request.getParameter("email") );
			u.setPassword( request.getParameter("password") );
			u.setUsertype( request.getParameter("usertype") );
			
			userservice.adduser(u);
			
			mv.setViewName("adminhome");
			
		} 
		catch (Exception e) {
			mv.setViewName("adduser");
		}
		
		return mv;
	}
	
	@PostMapping("addcomplaint")
	public ModelAndView addcomplaint(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException {

		ModelAndView mv = new ModelAndView();
		
		try {
			
			HttpSession session = request.getSession();
			int id = (int)session.getAttribute("id");
			
			Complaint c = new Complaint();
			c.setUserid(id);
			c.setGrp(request.getParameter("grp"));
			c.setIssue(request.getParameter("issue"));
			c.setStatus("Submitted");
			
			byte[] bytes = file.getBytes();
			Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			
			c.setImage(blob);
			
			System.out.println(c);
			
			complaintrepo.save(c);
			
			mv.addObject("ccount", userservice.complaintcountbyuser(request));
			mv.setViewName("home");
			
			
		} 
		catch (Exception e) {
			mv.setViewName("addcomplaint");
		}
		
		return mv;
	}
	
	@GetMapping("menu")
	public ModelAndView menu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menu");
		return mv;
	}
	
	@GetMapping("complaint")
	public ModelAndView complaint() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addcomplaint");
		
		return mv;
		
	}
	
	@GetMapping("userlogout")
	public ModelAndView userlogout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("message", "Logout Successful");
		return mv;
	}
	
	@GetMapping("home")
	public ModelAndView home(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
	    String name = (String)session.getAttribute("name");
	    
		long ccount = userservice.complaintcountbyuser(request);
		
		mv.addObject("name", name);
		mv.addObject("ccount", ccount);
		
		return mv;
		
	}
	
	@GetMapping("viewcomplaintsuser")
	public ModelAndView viewcomplaintsuser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewcomplaintsuser");
		return mv;
	}
	
	
	@GetMapping("adminhome")
	public ModelAndView adminhome() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		long ccount = adminservice.complaintcount();
		mv.addObject("ccount", ccount);
		long ucount = adminservice.userscount();
		mv.addObject("ucount", ucount);
		
		return mv;
		
	}
	
	@GetMapping("viewcomplaints")
	public ModelAndView viewcomplaints() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewcomplaints");
		
		List<Complaint> clist = adminservice.viewcomplaints();
		
		System.out.println(clist);
		mv.addObject("clist", clist);
		
		return mv;
		
	}
	
	@GetMapping("viewallusers")
	public ModelAndView viewallusers() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallusers");
		
		List<User> ulist = adminservice.viewallusers();
		mv.addObject("ulist", ulist);
		
		return mv;
		
	}
	
	@GetMapping("viewallhandlers")
	public ModelAndView viewallhandlers() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallhandlers");
		
		List<Handler> hlist = adminservice.viewallhandlers();
		mv.addObject("hlist", hlist);
		
		return mv;
		
	}
	
	@GetMapping("adminmenu")
	public ModelAndView adminmenu() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminmenu");
		
		return mv;
		
	}
	
	@GetMapping("displayimage")
	public ResponseEntity<byte[]> displayimage(@RequestParam("id") int id) throws IOException, SQLException {
	  Complaint complaint =  complaintservice.viewcomplaintbyid(id);
	  byte [] imageBytes = null;
	  imageBytes = complaint.getImage().getBytes(1,(int) complaint.getImage().length());

	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	
	@GetMapping("complaintscount")
	public long complaintscount() {
		return complaintservice.complaintcount();
	}
	
	@GetMapping("viewcomplaintbyid")
	public Complaint viewcomplaintbyid(int id) {
		return complaintservice.viewcomplaintbyid(id);
	}
	
}
