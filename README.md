# Rentr

Rentr is a rental management application built using Java and the Spring Boot framework.

## Table of Contents

- [Requirements](#requirements)
- [Building from Source](#building-from-source)
- [Running the Application](#running-the-application)
- [Design Overview](#design-overview)
- [Testing](#testing)

## Requirements

- Java 21 or higher
- Maven 3.2 or higher

If you don't have Java or Maven installed already, SDKMAN! is a great tool to manage multiple versions of Java on your machine. You can find more information and installation instructions at [https://sdkman.io/](https://sdkman.io/).

The project includes a docker-compose file to help you set up a PostgreSQL database quickly. If you want to use it, make sure you have Docker installed on your machine. You can find more information and installation instructions at [https://www.docker.com/get-started](https://www.docker.com/get-started).

The project includes a test script located in the `tools` directory to help you run integration tests against the application.
This script uses `curl` to make HTTP requests, so ensure you have `curl` installed on your machine. You can find more information and installation instructions at [https://curl.se/download.html](https://curl.se/download.html).
It also uses `jq` to parse JSON responses, so ensure you have `jq` installed on your machine. You can find more information and installation instructions at [https://stedolan.github.io/jq/download/](https://stedolan.github.io/jq/download/).

## Building from Source

To build the project from source, follow these steps:
Run the following command in the project root directory:

```bash
./mvnw clean install
```

This will compile the source code, run tests, and package the application.

## Running the Application

Before running the application, ensure that you have a PostgreSQL database set up and running. You can use the provided `docker-compose.yml` file to quickly spin up a PostgreSQL instance, the application is preconfigured to use this database. 
Run the following command in the tools directory:

```bash
docker compose up -d
```

To run the application, use the following command in the project root directory:

```bash
./mvnw spring-boot:run
```

This will start the application on the default port (8080). If you want to change the port or other configurations, you can modify the `application.yaml` file located in the `src/main/resources` directory.

## Design Overview

This application is built using the Spring Boot framework, which provides a robust and scalable foundation for developing web applications. The project follows the hexagonal architecture pattern, which promotes separation of concerns and makes the codebase more maintainable and testable. The layers of the application are organized as follows:
- **Domain Layer**: Contains the core business logic and domain entities.
- **Access layer**: Handles incoming requests and outgoing responses, including controllers and DTOs.
- **Infrastructure Layer**: Manages interactions with external systems, such as databases and third-party services.

## Testing

The project contains a test script located in the `tools` directory to help you run integration tests against the application.
To run the test script, use the following command in the tools directory:
```bash
./test_it.sh
```

This script will execute a series of integration tests to verify the functionality of the application. Make sure the application is running before executing the test script.

