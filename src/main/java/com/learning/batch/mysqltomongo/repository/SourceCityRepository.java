package com.learning.batch.mysqltomongo.repository;

import org.springframework.data.repository.CrudRepository;

import com.learning.batch.mysqltomongo.model.mysql.SourceCity;

public interface SourceCityRepository extends CrudRepository<SourceCity, Long> {

}
