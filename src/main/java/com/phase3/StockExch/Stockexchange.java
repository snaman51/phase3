package com.phase3.StockExch;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StockExchange")
public class Stockexchange {
	

	@Id
	@GeneratedValue
	private long id;

	private String name;
	@OneToMany(targetEntity = Companystockexchangemap.class)
	private List<Companystockexchangemap> compstockmap;

	public List<Companystockexchangemap> getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(List<Companystockexchangemap> compstockmap) {
		this.compstockmap = compstockmap;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Stockexchange() {
		
	}
}
