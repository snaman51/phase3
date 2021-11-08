package com.phase3.StockExch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Companyrepository extends JpaRepository<Company,Long> {
	
	public Company findBycompanyName(String name);
//	public Company findById(Long n);

}