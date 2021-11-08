package com.phase3.StockExch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class IPODetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Double pricePerShare;

	@Column(nullable = false)
	private Long totalNumberOfShares;
	
	@Column(nullable = false)
	private LocalDateTime openDateTime;

	@Column(nullable = false)
	private String exchName;
	
//	@Column(name="company_id",nullable = false)
//	private Long companyId;
	
	@Column(nullable = false)
	private Long companyCode;
	
	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	//fetch = FetchType.LAZY          
	@OneToOne( fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Company company;


	public String getExchName() {
		return exchName;
	}

	public void setExchName(String exchName) {
		this.exchName = exchName;
	}

	@ManyToMany
	private List<Stockexchange> stockExchanges = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(Double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Long getTotalNumberOfShares() {
		return totalNumberOfShares;
	}

	public void setTotalNumberOfShares(Long totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}

//	@JsonBackReference
//	public Company getCompany() {
//		return company;
//	}
//
//	@JsonManagedReference
//	public void setCompany(Company company) {
//		this.company = company;
//	}

	public List<Stockexchange> getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(List<Stockexchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	public IPODetail() {
	}

	public IPODetail(double pricePerShare, Long totalNumberOfShares, LocalDateTime openDateTime) {
		super();
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.setOpenDateTime(openDateTime);
	}

	public LocalDateTime getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(LocalDateTime openDateTime) {
		this.openDateTime = openDateTime;
	}
}
