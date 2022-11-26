package com.learning.batch.mysqltomongo.batch.writer;

import java.util.List;

import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.learning.batch.mysqltomongo.model.mysql.SourceCity;
import com.learning.batch.mysqltomongo.util.Constants;

public class MongoCustomWriter extends MongoItemWriter<SourceCity> {
	
	@Autowired
    public MongoTemplate mongoTemplate;

    public MongoCustomWriter() {
        super();
    }
    
    @Autowired
    public void setTemplate() {
        super.setTemplate(mongoTemplate);
    }
	
	@Override
	public void write(List<? extends SourceCity> items) throws Exception {
		mongoTemplate.insert(items, Constants.REPO_CITY);
	}
}
