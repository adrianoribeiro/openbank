# OpenBank API

## Tools:
* Spring MVC;
* Spring Security;
* Maven;
* Swagger;

## Commands

### Run test
mvn test

### Run app
mvn tomcat7:run-war -Dlog_path=<YOUR_LOG_PATH>

#### Sample of run app:
```
mvn tomcat7:run-war -Dlog_path=/home/adriano/logs/openbank.log
```

#### Login/password (it'll be need):
```
login: adriano, pass: 123456
```