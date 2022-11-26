# Spring Batch Examples - MySQL to MongoDB 

Project with examples using Spring Boot and Spring Batch.

This project shows how to configure a Spring Batch job to read data from MySQL database and copies to a NoSQL database - MongoDB with the help of scheduler batch processing and spring boot.

## Requirements

* Java 8
* You must set MySQL, and MongoDB databases installed on your system.
* Maven 3.5.* or higher
* The Lombok library is being used as a resource to help with the creation of classes, check if your IDE has support/plugin to use Lombok. More information at https://projectlombok.org.
* Import MySQL schema file `\src\main\resources\world.sql` into MySQL database.

## Getting Started

### Reference documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/maven-plugin/)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#howto-batch-applications)

### Guides
The guides below illustrate how to correctly use some spring batch features:

* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)

### Environment variables
The `application.properties` file in the `src / main / resources` folder contains the environment variables that will be used by the application.
If no environment variable is informed, the deafult values ​​will be used.
Description of the variables:

* `spring.datasource.url` : Connection string to the Spring Batch source repository database which is MySQL server address with the database name.
* `spring.datasource.username` : User connecting to the Spring Batch source repository database. 
* `spring.datasource.password` : Password for connecting to the Spring Batch source repository database.

* `spring.data.mongodb.host` : Server address of the Spring batch destination repository database which is a MongoDB.
* `spring.data.mongodb.port` : Server port no of the Spring batch destination repository MongoDB.
* `spring.data.mongodb.database` : Mongo Database name Spring batch destination repository.
* `spring.data.mongodb.username` : Username for connecting to the Spring Batch destination repository database.
* `spring.data.mongodb.password` : Password for connecting to the Spring Batch destination repository database.

* `scheduler.cron` : = The cron expression value used to perform Spring Batch jobs from time to time or periodically on a fixed time. The default value is `0 0 */2 * * ?` (At second:00, at the minute:00, every 2 hours starting at 00 am, of every day). 
* `scheduler.timezone` : The cron expression is evaluated based on this time zone. The default value is UTC.

### How to run

This application will copy values from one repository to another repository. Here source repository is a MySQL database and the destination repository is MongoDB. The primary aim is that Move all the values from the MySQL database which is Cities in the world to the Mongo database. And this migration happens with the use of various classes provided by Spring Batch.

* You can run start the application with the help of maven and apache tomcat as any spring boot runs.
* You can invoke the batch process by calling the controller `/invoke`. The default address of the API will be: `localhost:5800/invoke`.
* You can also configure the batch process as a scheduled job. You can configure the time in environment variables as mentioned above.

### Issue
This repository is maintained actively, so if you face any issue please <a href="#">raise an issue</a>.

#### Liked the work?
Give the repository a star :-)
