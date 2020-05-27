# Search Zip Code project
A RestFull service API to requet/search for Zip Code informations.

## Project Details
This project was developed using Java 8, Spring Boot v2.3.0, Apache Maven 3.5.0 for handle dependency, Junit to execute code tests, H2 in-memory database to eliminate the need for configuring and starting an actual database for test purposes, Swagger to provide the API documentation and Javadoc for generating API documentation from comments present in the source code.

### Prerequisites

Software installation required:
- Java SDK 1.8 ^
- Apache Maven 3.5.0 ^

### Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

* Make sure to have installed all softwares listed as prerequired
* Clone the repository https://github.com/jpmsouza/search-zipcode.git
* Open the code in a prefered Editor/IDE (For this project was used Jetbrains Intellij Idea)
* To run the project locally, execute the command: mvn spring-boot:run

## Database Additional Information

As already mentioned, for this project it was used the H2 in-memory database for test purposes. In the follwing tops are some addtional informat related to the  database access, struct and data.
* It was setup in application.yml the path, user and password for access the H2 database.
  - path: http://localhost:8082/h2-console
  - username: admin
  - password: admin
* The database schema/sctruct was implemented in a file named schema.sql (src/main/resources/schema.sql)
* the database initial data insert was implemeted in a file named data.sql (src/main/resources/data.sql)

## Design Code

To improve code strucuture, it was used the design pattern Abstract Factory at service layer to provide the abstraction of the code implemantion at this layer and through it facilitate the maintainability or exchange of this part of the code without impact the rest of code.

## Coding style tests

The tests was written using the framework support in Spring Boot and was implemented only unit tests to cover the code in an isolation form.

## Running the tests

To run the automated tests for this system execute the command: mvn test

## Deployment - Build and Running the Project with Maven

Add additional notes about how to deploy this on a live system:

* Execute the command to generate a package in target folder: mvn package
* Execute the command to run the .jar : java -jar target/search-zipcode-0.0.1-SNAPSHOT.jar
* Open a Browser and type http://localhost:8082/zip-code/{postalCode} (Ex: http://localhost:8082/zip-code/37582000)

## Additional documentation
* Swagger: http://localhost:8082/swagger-ui.html
* JavaDoc: /doc/index.html (Ex: C:/search-zipcode/doc/index.html)
