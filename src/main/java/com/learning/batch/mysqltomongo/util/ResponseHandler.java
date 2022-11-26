package com.learning.batch.mysqltomongo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
	
	private ResponseHandler() {
		throw new IllegalStateException("ResponseHandler Utility class");
	}
	
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj, String path) {
        Map<String, Object> map = new HashMap<>();
    	map.put(Constants.FIELD_TIMESTAMP, LocalDateTime.now());
    	map.put(Constants.FIELD_STATUS, status.value());
    	map.put(Constants.FIELD_MESSAGE, message);            
        map.put(Constants.FIELD_DATA, responseObj);
        map.put(Constants.FIELD_PATH, path);

        return new ResponseEntity<>(map,status);
    }
}