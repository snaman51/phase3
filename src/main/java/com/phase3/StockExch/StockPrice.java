package com.phase3.StockExch;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StockPrice")
public class StockPrice {
	
	@Id
	@GeneratedValue
	private long id;
	private String exchangename;
	private String companycode;
	private LocalDateTime localdatetime;
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	private Date datee;
	private Time timee;
	private float shareprice;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getExchangename() {
		return exchangename;
	}


	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}


	public String getCompanycode() {
		return companycode;
	}


	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}


	

	public StockPrice( String exchangename, String companycode,  
			Date datee, Time timee, float shareprice) {
		super();
	
		this.exchangename = exchangename;
		this.companycode = companycode;
		this.localdatetime = localdatetime;
		this.company = company;
		this.setDatee(datee);
		this.setTimee(timee);
		this.setShareprice(shareprice);
	}


	public Date getDatee() {
		return datee;
	}


	public void setDatee(Date datee) {
		this.datee = datee;
	}


	public Time getTimee() {
		return timee;
	}


	public void setTimee(Time timee) {
		this.timee = timee;
	}


	public float getShareprice() {
		return shareprice;
	}


	public void setShareprice(float shareprice) {
		this.shareprice = shareprice;
	}
}
