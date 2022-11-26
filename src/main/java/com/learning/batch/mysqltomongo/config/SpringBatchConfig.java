package com.learning.batch.mysqltomongo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.batch.mysqltomongo.batch.reader.MysqlCustomReader;
import com.learning.batch.mysqltomongo.batch.writer.MongoCustomWriter;
import com.learning.batch.mysqltomongo.listener.JobListener;
import com.learning.batch.mysqltomongo.model.mysql.SourceCity;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig extends DefaultBatchConfigurer {
	
	@Override
	public void setDataSource(DataSource dataSource) {
		throw new UnsupportedOperationException();
	}
	
	@Bean
	public SimpleJobLauncher jobLaucher(JobRepository jobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}
	
	@Bean
	@StepScope
	public MysqlCustomReader mysqlReader() {
		return new MysqlCustomReader();
	}
	
	@Bean
	@StepScope
	public MongoCustomWriter mongoWriter() {
		return new MongoCustomWriter();
	}
	
	@Bean
	@Qualifier("step")
	protected Step step(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("step")
				.<SourceCity, SourceCity>chunk(3)
				.reader(mysqlReader())
				.writer(mongoWriter())
				.faultTolerant()
				.retry(Exception.class)
				.retryLimit(3)
				.build();
	}
	
	@Bean(name="job")
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, JobListener listener) {
		return jobBuilderFactory.get("job")
				.start(step(stepBuilderFactory))
				.build();
	}
}
