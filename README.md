# Multi-Config

Minimal Maven **multi-module** project (JDK **17**) with:

- **common** — shared utilities  
- **domain** — domain model / logic  
- **service** — depends on `common` and `domain`  
- **web** — entry point depending on `service`

## Build

From the repository root:

```bash
mvn clean verify
```

- JUnit 5 (junit-bom), Surefire, and JaCoCo are preconfigured.

- Per-module coverage reports:
  - `<module>/target/site/jacoco/index.html`
- Aggregated coverage (all modules):
  - `target/site/jacoco-aggregate/index.html`

> Compiler target is set via maven.compiler.release=17.

## Profiles & Database

Profiles are defined in the parent POM:

- dev (active by default) — uses H2 in-memory for local development
- ci — reads DB URL from environment: db.connectionString = ${env.DB_URL}
- prod — same as ci (override with your production URL)

Switch profiles as needed:

```bash
# default (dev): H2 in-memory
mvn clean verify

# CI build (expects DB_URL env var)
DB_URL="jdbc:postgresql://db:5432/app" mvn -Pci clean verify

# Production-like build
DB_URL="jdbc:postgresql://prod-db:5432/app" mvn -Pprod clean verify
```

## Run the web module

### Using Maven Exec Plugin (recommended)

```bash
mvn -pl web exec:java "-Dexec.mainClass=com.example.web.WebApp"
```

### Using java directly

Windows:

```bash
java -cp common\target\common-1.0-SNAPSHOT.jar;domain\target\domain-1.0-SNAPSHOT.jar;service\target\service-1.0-SNAPSHOT.jar;web\target\web-1.0-SNAPSHOT.jar com.example.web.WebApp
```

Unix/macOS:

```bash
java -cp common/target/common-1.0-SNAPSHOT.jar:domain/target/domain-1.0-SNAPSHOT.jar:service/target/service-1.0-SNAPSHOT.jar:web/target/web-1.0-SNAPSHOT.jar com.example.web.WebApp
```

---

#### Note

JaCoCo agent is wired via prepare-agent; HTML coverage is produced on verify.
