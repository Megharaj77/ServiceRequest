package com.ntt.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ntt.infra.model.Status;

public interface StatusRepository extends JpaRepository<Status ,Integer>{

	@Query("SELECT s FROM status s JOIN sr_details sr ON s.id = sr.status.id WHERE sr.user.role.id = ?1 AND s.id = ?2")
	List<Status> findAllStatus(Integer roleId,Integer statusId);
	
	
	
	@Query("SELECT s FROM status s JOIN sr_details sr ON s.id = sr.status.id ")
	List<Status> findStatus();
}
