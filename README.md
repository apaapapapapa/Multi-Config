# Multi-Config

This is a minimal Maven multi-module project with the following modules:

- **common**: Provides shared utilities.
- **domain**: Represents domain-specific logic.
- **service**: Aggregates `common` and `domain` modules.
- **web**: Entry point module that depends on `service`.

## Building

From the root directory, run:

```bash
mvn clean install
```

This will build and install all modules into the local Maven repository.

## Running

After building, you can run the `web` module application. Use one of the following methods:

### Using Maven Exec Plugin

```bash
mvn -pl web exec:java -Dexec.mainClass="com.example.web.WebApp"
```

> Note: You may need to add the Maven Exec Plugin to the `web/pom.xml` if it is not already configured.

### Using Java Command

On Windows:

```bat
java -cp common/target/common-1.0-SNAPSHOT.jar;domain/target/domain-1.0-SNAPSHOT.jar;service/target/service-1.0-SNAPSHOT.jar;web/target/web-1.0-SNAPSHOT.jar com.example.web.WebApp
```

On Unix/macOS:

```bash
java -cp common/target/common-1.0-SNAPSHOT.jar:domain/target/domain-1.0-SNAPSHOT.jar:service/target/service-1.0-SNAPSHOT.jar:web/target/web-1.0-SNAPSHOT.jar com.example.web.WebApp
