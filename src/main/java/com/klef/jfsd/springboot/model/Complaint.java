package com.klef.jfsd.springboot.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="complaint_table")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int userid;
	
	@Column(nullable = false)
	private String grp;
	
	@Column(nullable = false)
	private String issue;
	
	@Column(nullable = false)
	private String status;
	
	private Blob image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String b) {
		this.status = b;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", userid=" + userid + ", grp=" + grp + ", issue=" + issue + ", status=" + status
				+ ", image=" + image + "]";
	}
	
}
