package com.phase3.StockExch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Stockpricerepository extends JpaRepository<StockPrice,Long> {
	

}
