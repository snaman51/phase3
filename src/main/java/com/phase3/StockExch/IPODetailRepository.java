package com.phase3.StockExch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPODetailRepository extends JpaRepository<IPODetail,Long> {
	
	
public List<IPODetail> findByCompanyCode(Long companyCode);
}
