package com.learning.batch.mysqltomongo.batch.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.learning.batch.mysqltomongo.model.mysql.SourceCity;
import com.learning.batch.mysqltomongo.util.CityRowMapper;
import com.learning.batch.mysqltomongo.util.Constants;

public class MysqlCustomReader extends JdbcCursorItemReader<SourceCity> {
	
	@Autowired
    public DataSource dataSource;

    public MysqlCustomReader() {
        super();
    }
    
    @Autowired
    public void setDataSourceIn() {
        super.setDataSource(dataSource);
    }

    @Autowired
    public void setRowMapper() {
        super.setRowMapper(new CityRowMapper());
    }

    @Autowired
    public void setSql() {
        super.setSql(Constants.MYSQL_READER_QUERY);
    }

}
