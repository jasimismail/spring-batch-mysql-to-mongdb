package com.learning.batch.mysqltomongo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.batch.mysqltomongo.batch.SpringBatchManager;
import com.learning.batch.mysqltomongo.util.ResponseHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SpringBatchController {
	
	@Autowired
	private SpringBatchManager manager;
	
	@GetMapping("/invoke")
	public ResponseEntity<Object> invoke(HttpServletRequest request) throws Exception {
		try {
			log.info("Invoked batch job through controller");
			manager.invokeBatchJob();
			log.info("Invoked batch job through controller completed");
			return ResponseHandler.generateResponse("Successfully processed data!", HttpStatus.OK, "Ok", request.getRequestURI());
		} catch(Exception e) {
			return ResponseHandler.generateResponse("Error happened while processing data!", HttpStatus.CONFLICT, e.getMessage(), request.getRequestURI());
		}
	}
}