package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TravelHomeData {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column
	private long id;
		
	@Column()
	private String date;
	
	@Column(length = 50, nullable = false)
	private String comment;
	
	@ManyToOne
//	@JoinColumn(name="user_id")
	private TravelData traveldata;
	
	public long getId(){ return id; }
	public void setId(long id) { this.id = id; }
		
	public String getDate(){ return date; }
	public void setDate(String date) { this.date = date; }
	
	public String getComment(){ return comment; }
	public void setComment(String comment) { this.comment = comment; }
	
	public TravelData getTravelData() {
        return traveldata;
    }

    public void setTravelData(TravelData traveldata) {
        this.traveldata = traveldata;
    }
	
}
