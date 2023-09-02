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
- 
2. Set up your Apache Kafka
### Run your kafkfa service at your local (Windows)

### Test with Postman
