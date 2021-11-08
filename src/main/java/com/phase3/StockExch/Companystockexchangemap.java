package com.phase3.StockExch;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CompanyStockexchangemap")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Companystockexchangemap {
	public Companystockexchangemap() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private long id;
	
	
	private String CompanyCode;
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	@ManyToOne(fetch = FetchType.LAZY)
	private Stockexchange stockexchange;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
       public String getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}

	public Stockexchange getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(Stockexchange stockexchange) {
		this.stockexchange = stockexchange;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

