package com.learning.batch.mysqltomongo.model.mongo;

import lombok.Data;

@Data
public class City {
	private long id;
	private String name;
	private String countryCode;
	private String district;
	private String population;
}
