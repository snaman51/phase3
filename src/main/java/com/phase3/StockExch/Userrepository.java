package com.phase3.StockExch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User1,Long> {

	public User1 findByemail(String email);
}
