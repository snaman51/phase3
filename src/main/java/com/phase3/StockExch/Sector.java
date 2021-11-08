package com.phase3.StockExch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Sector {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@Column(nullable = false)
	private String sectorName;


	@Column(nullable = false)
	private String brief;


	@OneToMany(mappedBy = "sector")
	@JsonIgnore
	private List<Company> companies = new ArrayList<>();


	protected Sector() {
	}


	public Sector(String sectorName, String brief) {
		super();
		this.sectorName = sectorName;
		this.brief = brief;
	}
}

