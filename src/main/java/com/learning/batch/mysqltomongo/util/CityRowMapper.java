package com.learning.batch.mysqltomongo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.learning.batch.mysqltomongo.model.mysql.SourceCity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CityRowMapper implements RowMapper<SourceCity> {

	@Override
	public SourceCity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SourceCity city = new SourceCity();
    	city.setId(rs.getLong(Constants.FIELD_ID));
    	city.setCountryCode(rs.getString(Constants.FIELD_COUNTRY_CODE));
    	city.setDistrict(rs.getString(Constants.FIELD_DISTRICT));
    	city.setName(rs.getString(Constants.FIELD_NAME));
    	city.setPopulation(Constants.FIELD_POPULATION);
    	log.debug("city: {}", city);
        return city;
	}

}
