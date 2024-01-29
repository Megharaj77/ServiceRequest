package com.ntt.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.infra.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
