# Hello!! This is a spring boot app!

This app is simple. It connects to a postgres database and says if the database works.

Requirements:
- Java 21

## Commands
The following commands should help you build and test your application.
### Build the app
```bash
./mvnw clean package
```

The `.jar` file will be available in `target` directory. 

### Build the app without running tests
```bash
./mvnw clean package -DskipTests
```

The `.jar` file will be available in `target` directory.


### Test the app
```bash
./mvnw test
```

### Run the app locally
```bash
./mvnw spring-boot:run
```

### Build the documentation
```bash
./mvnw javadoc:javadoc
```

The static site files will be available in `target/reports/apidocs`.

