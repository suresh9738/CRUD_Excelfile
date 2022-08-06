package com.suresh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suresh.demo.entity.Exercise;
import com.suresh.demo.entity.ResponseMessage;
import com.suresh.demo.service.CSVService;
import com.suresh.demo.util.CSVHelper;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	CSVService fileService;
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	        fileService.save(file);
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }
	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
	
	  @GetMapping("/exercise")
	  public ResponseEntity<List<Exercise>> getAllExercise() {
	    try {
	      List<Exercise> exercise = fileService.getAllExercise();
	      if (exercise.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(exercise, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/exercise/{code}")
	  public ResponseEntity<Exercise> getExercise(@PathVariable("code") String code) {
	    try {
	      Exercise exercise = fileService.getExercise(code);
	      if (exercise == null) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(exercise, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @DeleteMapping("/delete")
	  public ResponseEntity<ResponseMessage> deleteExercise() {
	    try {
	      String status = fileService.deleteAllExercise();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(status));
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
