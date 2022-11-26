package com.learning.batch.mysqltomongo.batch;

import java.time.LocalDateTime;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.learning.batch.mysqltomongo.exception.BatchJobException;
import com.learning.batch.mysqltomongo.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class SpringBatchManager {

	@Autowired
	private SimpleJobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	public void invokeBatchJob() throws BatchJobException {
		try {
			log.info("Starting batch job, time: {}", LocalDateTime.now());
			JobParameters jobParam = new JobParametersBuilder()
					.addString("JobID", String.valueOf(System.currentTimeMillis()))
					.toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParam);			
			log.info("Batch job completed, status: {}, time: {}", execution.getStatus(), LocalDateTime.now());
			if (execution.getStatus() != BatchStatus.COMPLETED) {
				String stackTrace = CommonUtils.getRootCauseStackTrace(execution.getAllFailureExceptions());
				throw new BatchJobException(stackTrace);
			}
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
			throw new BatchJobException(e.getMessage());
		} catch (BatchJobException be) {
			throw new BatchJobException(be.getMessage());
		}
	}
	
	@Scheduled(cron = "${scheduler.cron}", zone = "${scheduler.timezone}")
	private void triggerBatchJob() {
		try {
			log.info("Scheduled batch job is triggerred");
			invokeBatchJob();			
		} catch (Exception e) {
			log.error("Exception occurred while invokeBatchJob, log: {}", ExceptionUtils.getStackTrace(e));
		} finally {
			log.info("Scheduled batch job triggerred is completed");
		}
	}

}
