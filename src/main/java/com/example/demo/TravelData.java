package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class TravelData {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column
	private long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String mail;
		
	@Column(length = 50, nullable = false)
	private String pass;
	
	public long getId(){ return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName(){ return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMail(){ return mail; }
	public void setMail(String mail) { this.mail = mail; }
	
	public String getPass(){ return pass; }
	public void setPass(String pass) { this.pass = pass; }
	
//	@Column
//	private long id0;
//		
//	@Column()
//	private String date;
//	
//	@Column(length = 50, nullable = false)
//	private String comment;
//	
//	public long getId0(){ return id0; }
//	public void setId0(long id0) { this.id0 = id0; }
//	
//		
//	public String getDate(){ return date; }
//	public void setDate(String date) { this.date = date; }
//	
//	public String getComment(){ return comment; }
//	public void setComment(String comment) { this.comment = comment; }
	
}
