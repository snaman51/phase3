package com.phase3.StockExch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stockrepository extends JpaRepository<Stockexchange,Long> {
	public Stockexchange findByName(String name);
}
