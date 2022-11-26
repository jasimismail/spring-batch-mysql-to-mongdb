package com.learning.batch.mysqltomongo.listener;

import java.util.List;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobListener extends JobExecutionListenerSupport {
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("beforeJob method started, status: {}", jobExecution.getStatus());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("afterJob method started, status: {}", jobExecution.getStatus());
		if (jobExecution.getStatus().isUnsuccessful()) {
			log.error("Job is failed due to below errors");
		    List<Throwable> exceptions = jobExecution.getAllFailureExceptions();
		    for (Throwable t : exceptions) {
		        log.error(t.getMessage());
		    }
		}
	}

}
