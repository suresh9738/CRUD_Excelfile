package com.suresh.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suresh.demo.entity.Exercise;
import com.suresh.demo.repository.ExerciseRepository;
import com.suresh.demo.util.CSVHelper;

@Service
public class CSVService {

	@Autowired
	ExerciseRepository exerciseRepository;
	
	public void save(MultipartFile file) {
		try {
			List<Exercise> exerciseList = CSVHelper.csvToExercise(file.getInputStream());
			for(Exercise exercise : exerciseList) {
				exerciseRepository.save(exercise);
			}
		} catch (IOException e) {
			throw new RuntimeException("failed to store csv data: " + e.getMessage());
		}
	}
	public List<Exercise> getAllExercise() {
		try {
			return exerciseRepository.findAll();
		} catch(Exception e) {
			throw new RuntimeException("failed to get all csv data: " + e.getMessage());
		}
	}
	
	public Exercise getExercise(String code) {
		try {
			return exerciseRepository.findByCode(code);
		} catch(Exception e) {
			throw new RuntimeException("failed to get csv data by code : " + e.getMessage());
		}
	}
	
	public String deleteAllExercise() {
		try {
			exerciseRepository.deleteAll();
			return "Successfully Deleted all Exercise!.";
		} catch(Exception e) {
			throw new RuntimeException("failed to delete all csv data : " + e.getMessage());
		}
	}
}
