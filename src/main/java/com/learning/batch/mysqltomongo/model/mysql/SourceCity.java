package com.learning.batch.mysqltomongo.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.learning.batch.mysqltomongo.util.Constants;

import lombok.Data;

@Data
@Entity
@Table(name=Constants.REPO_CITY)
public class SourceCity {
	
	@Id
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="CountryCode")
	private String countryCode;
	
	@Column(name="District")
	private String district;
	
	@Column(name="Population")
	private String population;

}
