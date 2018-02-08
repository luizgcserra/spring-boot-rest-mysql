# spring-boot-rest-mysql
Rest API Spring Boot with MySQL example

This repository aims to show an example of how to implement a REST API using Spring Boot, persisting data in MySQL Database.

To run this example follow these steps:

1. Install Java 8 (https://java.com/en/download/)
2. Install Eclipse IDE (http://www.eclipse.org/downloads)
3. Install MySQL Database (https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-16-04)
4. Install Maven (https://maven.apache.org/)
5. Into Eclipse IDE, install Spring Boot Tools at Eclipse Marketplace finding by STS. (https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite)
6. Open project, the Maven Dependencies will be downloaded.
7. Start MySQL service
8. Create a database:
```sql
create database contoso;
```
9. Create "customer" table in "contoso" database:
```sql
use contoso;

CREATE TABLE customer(
   id int PRIMARY KEY,
   firstname varchar(40),
   lastname varchar(40),
   email varchar(60)
);
```
    
10. Optionally, you can create the "email" index to search:
```sql
CREATE INDEX idx_customer_email ON customer (email(60));
```
11. Change environment settings in the "/spring-boot-rest-mysql/src/main/resources/application.properties" file.
12. Run project into Eclipse IDE or command line: `mvn spring-boot:run`

## Benchmarks

The load test was run Virtualized (Virtual Box) Linux Ubuntu 16.04 LTS operational system, 4vCPU, 6GB RAM and HDD. The physical machine is a Windows 10 operational system, Intel i7 7th Gen, 16GB RAM.

### JMeter Thread Group Settings

Number of threads (Users): 1000

Ramp-Up (sec): 10

Loop Count: 200

### Test Scenario

Using Apache JMeter to read a CSV file with 200.000 rows containing person attributes (Id, Firstname, Lastname and Email) to invoke the REST API.

#### Scenario #1: Insert Data (POST)

Samples: 200.000

Request AVG: 846 ms

Request MIN: 3 ms

Request MAX: 17926 ms

Thoughput: 1086.3 req/sec

Total Time: 00:03:03

#### Scenario #2: Retrieve Data (GET)

Samples: 200.000

Request AVG: 659 ms

Request MIN: 1 ms

Request MAX: 16954 ms

Thoughput: 1317.0 req/sec

Total Time: 00:02:31




