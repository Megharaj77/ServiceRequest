package com.ntt.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ntt.infra.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM user u WHERE u.name = ?1 AND u.passwd = ?2")
	public User validateUser(String name,String passwd);
	
	
}
