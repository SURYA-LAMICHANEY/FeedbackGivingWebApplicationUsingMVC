package guideMe.model;

import java.io.InputStream;


public class Teacher {
	
	private String uid="Teacher";
	private String name;	
	private String userid="u";
	private String password;
	private String selfreliance=";";
	private String subid=";";
	private String subname;
	private String department=";";
	private InputStream photo;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSelfreliance() {
		return selfreliance;
	}
	public void setSelfreliance(String selfreliance) {
		this.selfreliance = selfreliance;
	}	
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
