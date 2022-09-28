# BootifyStarter
Bootify   Spring Boot REST API with database in minutes

## Urls
- https://bootify.io/

##  Docs
- https://www.axopen.com/blog/2021/10/webpack-projet-front-end-tuto/

<<<<<<< HEAD
# MyApp
=======
-**  https://www.danvega.dev/docs/spring-boot-2-docs/

- Main Repo This is a reddit clone built using Spring Boot 2. I created this project to show off all the cool features of Spring Boot 2.
- https://github.com/cfaddict/springit

- UI Templates
These are the HTML templates that we are using to build out UI for this course. I wanted to provide the raw templates before we start introducing Thymleaf into the equation.

- https://github.com/cfaddict/springit-templates

## MyApp
>>>>>>> 8f0060897f9fa6a3bf65fb47de9cd18a75250132

This app was created with Bootify.io - more documentation [can be found here](https://bootify.io/docs/). Feel free to contact us for further questions.

## Development

During development it is recommended to use the profile `local`. In IntelliJ, `-Dspring.profiles.active=local` can be added in the VM options of the Run Configuration after enabling this property in "Modify options".

Update your local database connection in `application.properties` or create your own `application-local.properties` file to override settings for development.

After starting the application it is accessible under `localhost:8080`.

## Build

The application can be built using the following command:

```
mvnw clean package
```

The application can then be started with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./target/my-app-0.0.1-SNAPSHOT.jar
```

## Further readings

* [Maven docs](https://maven.apache.org/guides/index.html)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
* [Thymeleaf docs](https://www.thymeleaf.org/documentation.html)  
* [Bootstrap docs](https://getbootstrap.com/docs/5.2/getting-started/introduction/)  
