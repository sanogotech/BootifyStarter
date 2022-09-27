# BootifyStarter
Bootify   Spring Boot REST API with database in minutes

## Urls
- https://bootify.io/

##  Docs
- https://www.axopen.com/blog/2021/10/webpack-projet-front-end-tuto/

-**  https://www.danvega.dev/docs/spring-boot-2-docs/

- Main Repo This is a reddit clone built using Spring Boot 2. I created this project to show off all the cool features of Spring Boot 2.
- https://github.com/cfaddict/springit

- UI Templates
These are the HTML templates that we are using to build out UI for this course. I wanted to provide the raw templates before we start introducing Thymleaf into the equation.

- https://github.com/cfaddict/springit-templates

## MyApp

This app was created with Bootify.io - more documentation [can be found here](https://bootify.io/docs/). Feel free to contact us for further questions.

## Development

During development it is recommended to use the profile `local`. In IntelliJ, `-Dspring.profiles.active=local` can be added in the VM options of the Run Configuration after enabling this property in "Modify options".

Update your local database connection in `application.properties` or create your own `application-local.properties` file to override settings for development.

In addition to the Spring Boot application, the DevServer must also be started. [Node.js](https://nodejs.org/) has to be available on the system - the latest LTS version is recommended. Only once the dependencies have to be installed:

```
npm install
```

Please note that the there is a warning during build, where no update is available yet: https://github.com/svg/svgo/issues/1689

The DevServer can now be started as follows:

```
npm run devserver
```

Using a proxy the whole application is now accessible under `localhost:8081`. All changes to the templates and JS/CSS files are immediately visible in the browser.

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
