package com.ntt.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.infra.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
