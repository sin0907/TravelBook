package com.example.demo;

import java.util.List;

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
	
	@OneToMany(mappedBy="traveldata", cascade=CascadeType.ALL)
	private List<TravelHomeData> TravelHomeData;
	
	public long getId(){ return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName(){ return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMail(){ return mail; }
	public void setMail(String mail) { this.mail = mail; }
	
	public String getPass(){ return pass; }
	public void setPass(String pass) { this.pass = pass; }
	
	public List<TravelHomeData> getTravelHomeData() {
	return TravelHomeData;
	}

	 public void setTravelHomeData(List<TravelHomeData> travelhomedata) {
	 this.TravelHomeData = travelhomedata;
	 }
	
}
