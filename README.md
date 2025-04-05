# Anime Rating Aggregator

Este projeto é uma API desenvolvida com **Quarkus** que busca informações de animes utilizando a **Jikan API** (MyAnimeList), obtém avaliações adicionais da **OMDb API** (IMDb) e do **Rotten Tomatoes** via web scraping, e salva essas informações em um banco de dados **H2**.

---

## ✨ Funcionalidades

- Buscar informações de um anime por ID via Jikan API.
- Consultar avaliações no OMDb por título.
- Scraping da nota dos críticos no Rotten Tomatoes por título.
- Armazenar avaliações e metadados em banco de dados relacional H2.
- Integração via REST Client com múltiplas fontes de dados.
- Arquitetura separada em Camadas (Controller, Service, Repository).

---

## 🔧 Tecnologias Utilizadas

- Java 17+
- Quarkus
- H2 Database
- Hibernate ORM + Panache
- REST Client (MicroProfile)
- JAX-RS
- Jsoup (Web Scraping)
- Lombok

---

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/animelist-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- REST Client ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### REST Client

Invoke different services through REST with JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
