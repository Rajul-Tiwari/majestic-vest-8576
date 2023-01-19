package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Activity;

public interface ActivityDao extends JpaRepository<Activity, Integer> {
	
	public List<Activity> findByCharge(Float charge);
	

}
