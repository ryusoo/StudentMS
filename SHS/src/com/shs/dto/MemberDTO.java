package com.shs.dto;

import java.util.Date;

public class MemberDTO {
	
	// 실제 값이 다 들어가는 변수
	private int sid;
	private String sname;
	private int sage;
    private String smajor;
    private String sphone;
    private Date regdate;
		    
    
    // 기본 생성자
	public MemberDTO() {
		  
	}
	
	// 한번에 값을 다 넣을 때 생성자
	public MemberDTO(int sid, String sname, int sage, String smajor, String sphone, Date regdate) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
		this.regdate = regdate;
	}

	
	// 이름, 나이, 전공, 전화번호 담는 생성자
	public MemberDTO(String sname, int sage, String smajor, String sphone) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
	}
	
	// id, name, age, major, phone 5개를 담는 생성자
	public MemberDTO(int sid, String sname, int sage, String smajor, String sphone) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
	}

	// toString 값 한번에 보고 싶을 때
	@Override
	public String toString() {
		return "MemberDTO [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", smajor=" + smajor + ", sphone="
				+ sphone + ", regdate=" + regdate + "]";
	}
	
	

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
		    
		    
	   
	
	
}
