package com.ntt.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntt.infra.model.RequestType;
import com.ntt.infra.model.User;

@Repository
public interface RequestTypeRepository extends JpaRepository<RequestType, Integer>{

	@Query("SELECT r FROM request_type r JOIN sr_details s ON r.id = s.requestType.id WHERE s.user.id = ?1")
	List<RequestType> findRequestByUser(Integer userId);
	
	
}
