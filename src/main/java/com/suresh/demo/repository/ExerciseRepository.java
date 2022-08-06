package com.suresh.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suresh.demo.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Serializable> {
	
//	@Query("select s from Exercise s where s.code = ?1")
	public Exercise findByCode(String code);
	
}
