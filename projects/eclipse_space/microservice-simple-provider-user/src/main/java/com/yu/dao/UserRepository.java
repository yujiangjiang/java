package com.yu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yu.bo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
