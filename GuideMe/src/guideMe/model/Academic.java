package guideMe.model;

import java.sql.Timestamp;

public class Academic {
  private int fid;
  private String tid;
  private String sid;
  private String subid;
  private Timestamp date;
  private String marks;
  private String remarks;
  private int status;
  
  
  
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSubid() {
	return subid;
}
public void setSubid(String subid) {
	this.subid = subid;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp today) {
	this.date = today;
}
public String getMarks() {
	return marks;
}
public void setMarks(String mark) {
	this.marks = mark;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}  
}
