package com.nyeon.driverslicense.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.nyeon.driverslicense.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	public List<License> findAll();
	
	public License findTopByOrderByNumberDesc();
	
	public List<License> findByStateContaining(String state);
}
