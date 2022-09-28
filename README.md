# BootifyStarter
Bootify   Spring Boot REST API with database in minutes

## Urls
- https://bootify.io/

##  Docs
- https://www.axopen.com/blog/2021/10/webpack-projet-front-end-tuto/

## MyApp

This app was created with Bootify.io - more documentation [can be found here](https://bootify.io/docs/). Feel free to contact us for further questions.

## API  SWAGGER
- http://localhost:8080/swagger-ui/index.html

## Build

The application can be built using the following command:

```
mvnw clean package
```

Node.js is automatically downloaded using the `frontend-maven-plugin` and the final JS/CSS files are integrated into the jar.

The application can then be started with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./target/my-app-0.0.1-SNAPSHOT.jar
```

## Further readings

* [Maven docs](https://maven.apache.org/guides/index.html)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
* [Thymeleaf docs](https://www.thymeleaf.org/documentation.html)  
* [Webpack concepts](https://webpack.js.org/concepts/)  
* [npm docs](https://docs.npmjs.com/)  
* [Bootstrap docs](https://getbootstrap.com/docs/5.2/getting-started/introduction/)  
