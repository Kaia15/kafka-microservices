# Spring Boot & Kafka Microservices Documentation

### 1. Set up your spring boot

Set up database at your local
- Refer to documentation https://www.postgresql.org/docs/ from PostgreSQL, and https://www3.ntu.edu.sg/home/ehchua/programming/sql/PostgreSQL_GetStarted.html, install PostgresSQL.
- Login PSQL with following database info:
> psql -U ${username} ${database_name}
> Enter your password with username ${username}: ${password}

Set up your application 
- Access via link: https://start.spring.io/ to download your spring boot application package.
- Some packages added to download: PomXML, data-jbc, jpa, SQL (Postgresql, MySQL), rest, web, etc.
- After installation, export .zip folder and open in VSCode.
- Ctrl + P, type application.properties => open this file and add the following information:
> spring.datasource.url=jdbc:postgresql://localhost:5432/userdb

> spring.datasource.username=postgres

> spring.datasource.password=197515
- Test: Write a sample controller called `GreetingController.java` to see the application run well or not.

### 2. What is Apache Kafka & Set up Kafka

### 3. Run your kafkfa service at your local (Windows)

### 4. Test with Postman
