# customerservice1

# Before running this applicaiton need to update following Application Properties 
```

1. spring.datasource.url: Need to put valid postgreSQL database name & port 
2. spring.datasource.username: Need to put valid postgreSQL user 
3. spring.datasource.password: Password for the PostgreSQL database
```

#Spring Boot Application Build & Run Documentation Prerequisites
```
Java Development Kit (JDK): Ensure JDK 17 or higher .
Apache Maven:  Maven 3.6.0 or higher is installed.
PostgreSQL Database: Ensure PostgreSQL is running.
ELK docker container
Update application.properties
```

# project running steps
```
navigate to application directory
docker compose up -d 
mvn clean package 
java -jar target/customerservice-1.0-SNAPSHOT.jar
```

# project testing steps
```
1.Import postman colleciton file from bellow location.
\postmancolleciton\springbatch.postman_collection.json
2. fistly need to call authentication api for token generation.
3. then test other api (update , search)

```

```
       Technology stack 
1.       Spring boot 3. 
2.       PostgreSQL
3.       ELK
4.       Fly 
```

