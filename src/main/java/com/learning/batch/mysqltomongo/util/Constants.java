package com.learning.batch.mysqltomongo.util;

public class Constants {
	
	private Constants() {
		throw new IllegalStateException("Constants Utility class");
	}
	
	public static final String MYSQL_READER_QUERY = "SELECT * FROM world.city";
	
	public static final String REPO_CITY = "city";
	
	public static final String FIELD_ID = "id";
	public static final String FIELD_COUNTRY_CODE = "countryCode";
	public static final String FIELD_DISTRICT = "district";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_POPULATION = "population";
	
	public static final String FIELD_TIMESTAMP = "timestamp";
	public static final String FIELD_STATUS = "status";
	public static final String FIELD_MESSAGE = "message";
	public static final String FIELD_DATA = "data";
	public static final String FIELD_PATH = "path";


}
