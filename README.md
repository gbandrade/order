# Order

API responsible for order flow management

[Documentação](http://localhost:8080/doc.html)


## Prerequisites

- JDK 17.
- [Docker](https://docs.docker.com/engine/install/) (For development)


### Installing the JDK with SDKMAN

SDKMAN is a version manager for Java, Gradle, Groovy, etc. To install it and then the JDK, follow these steps:

```bash
curl -s "https://get.sdkman.io" | bash
```

To list JDK options:

```bash
sdk list java
```

After installation, install the JDK of your choice:

```bash
sdk install java 17.0.10-zulu
```

Referência: [https://sdkman.io/](https://sdkman.io/).

## Running the Application

The command below will execute the default Gradle task to generate the dynamic classes, generate the stubs and download the java project dependencies:

```bash
./gradlew
```

The command below runs the java project on port 8080 on the localhost:

```bash
./gradlew bootRun
```

The command below runs the java project with the Development profile:

```bash
./gradlew bootRun -Dspring.profiles.active=development