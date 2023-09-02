# Spring Boot & Kafka Microservices Documentation

## Overview

- Created a RESTful backend server using Spring Boot, comprising 4 crucial microservices (email, user, notification,
and subscription) essential for a Youtube-liked platform.
- Enabled real-time notifications for users using Kafka (Kafka topic, producer, consumer).

### Set up your spring boot

1. Set up database at your local
- Refer to documentation https://www.postgresql.org/docs/ from PostgreSQL, and https://www3.ntu.edu.sg/home/ehchua/programming/sql/PostgreSQL_GetStarted.html, install PostgresSQL.
- Login PSQL with following database info:
> psql -U ${username} ${database_name}
> Enter your password with username ${username}: ${password}

2. Set up your application 
- Access via link: https://start.spring.io/ to download your spring boot application package.
- Some packages added to download: PomXML, data-jbc, jpa, SQL (Postgresql, MySQL), rest, web, etc.
- After installation, export .zip folder and open in VSCode.
- Ctrl + P, type application.properties => open this file and add the following information:
> spring.datasource.url=jdbc:postgresql://localhost:5432/userdb

> spring.datasource.username=postgres

> spring.datasource.password=197515
- Test: Write a sample controller called `GreetingController.java` to see the application run well or not.

### What is Apache Kafka & Set up Kafka
1. What is Apache kafka
- See how Apache Kafka explain: https://www.youtube.com/watch?v=vHbvbwSEYGo
- Also, event streaming processing is helpful to explain why we use Kafka: https://www.confluent.io/learn/event-streaming/#:~:text=Event%20stream%20processing%20(ESP)%20is,and%20operate%20as%20events%20occur.
  
2. Set up your Apache Kafka
- Refer to this docs: https://kafka.apache.org/downloads, install kafka and export .zip folder. (should use `tar xvf kafka_version` instead of normally exporting it with Windows tool).
  
### Run your kafkfa service at your local (Windows)
- Start Zookeeper Service: ` ./bin/windows/zookeeper-server-start.bat config/zookeeper.properties`
- Start Kafka server: `./bin/windows/kafka-server-start.bat config/server.properties`
- One of these, if not working, please check C:\tmp, which is the directory where kafka-logs and zookeeper were created and delete them, then, restart previous steps.
### Test with Postman
