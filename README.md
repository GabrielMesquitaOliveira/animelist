# 🌟 Anime Rating Aggregator 🌟

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![Quarkus](https://img.shields.io/badge/Quarkus-3.21.1-red.svg)](https://quarkus.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Dive into the ultimate anime universe! 🚀 This powerful API aggregates ratings from **MyAnimeList (Jikan API)**, **IMDb (OMDB API)**, and **Rotten Tomatoes** via web scraping, delivering a comprehensive score for your favorite animes. Built with **Quarkus** for lightning-fast performance, it stores everything in an **H2 in-memory database** for seamless development and testing.

![Anime Banner](https://via.placeholder.com/800x200/FF6B6B/FFFFFF?text=Anime+Rating+Aggregator)  
*(Imagine a vibrant anime-themed banner here!)*

---

## ✨ Features

- **🔍 Multi-Source Rating Aggregation**: Fetch anime details from Jikan API and pull ratings from OMDB and Rotten Tomatoes in one go.
- **💾 Persistent Storage**: Save aggregated data to H2 database with Hibernate ORM + Panache for easy querying and updates.
- **🌐 RESTful API**: Simple endpoints to retrieve anime info with all ratings combined.
- **🕷️ Web Scraping Magic**: Uses Jsoup to scrape Rotten Tomatoes critics' scores – because who doesn't love a bit of web wizardry?
- **⚡ Blazing Fast**: Quarkus-native performance with live reload in dev mode.
- **🛠️ Developer-Friendly**: Includes H2 console, OpenAPI docs, and easy Docker support.

---

## 🛠️ Tech Stack

- **Backend**: Java 17, Quarkus Framework
- **Database**: H2 (In-Memory for Dev, Configurable for Prod)
- **ORM**: Hibernate ORM with Panache
- **APIs**: REST Client (Jikan, OMDB), Jsoup for Scraping
- **Build Tool**: Maven
- **Other**: Lombok, JAX-RS, JSON Processing

---

## 🚀 Installation & Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Clone & Run
1. **Clone the repo**:
   ```bash
   git clone https://github.com/yourusername/animelist.git
   cd animelist
   ```

2. **Run in Dev Mode** (with live reload):
   ```bash
   ./mvnw quarkus:dev
   ```
   - Access the app at: `http://localhost:8080`
   - Dev UI: `http://localhost:8080/q/dev/`
   - H2 Console: `http://localhost:8080/h2-console`

3. **Package for Production**:
   ```bash
   ./mvnw package
   java -jar target/quarkus-app/quarkus-run.jar
   ```

4. **Native Build** (for ultra-speed):
   ```bash
   ./mvnw package -Dnative
   ./target/animelist-1.0.0-SNAPSHOT-runner
   ```

### Docker Support
Build and run with Docker:
```bash
docker build -f src/main/docker/Dockerfile.jvm -t animelist .
docker run -p 8080:8080 animelist
```

---

## 📖 Usage

Once running, hit the API to get aggregated anime data!

### Example Request
```bash
curl http://localhost:8080/anime/1
```

### Sample Response
```json
{
  "data": {
    "mal_id": 1,
    "title": "Cowboy Bebop",
    "score": 8.75,
    "imdb_score": 8.9,
    "rotten_score": 91.0,
    ...
  }
}
```

- **MyAnimeList Score**: From Jikan API
- **IMDb Score**: Fetched from OMDB API
- **Rotten Tomatoes Score**: Scraped from critics' reviews

---

## 🔗 API Endpoints

| Method | Endpoint       | Description                          |
|--------|----------------|--------------------------------------|
| GET    | `/anime/{id}` | Get anime by MAL ID with all ratings |

### Parameters
- `id` (int): MyAnimeList anime ID (e.g., 1 for Cowboy Bebop)

### Notes
- Ratings are aggregated on-the-fly.
- If a source is unavailable, the score will be `null`.
- Data is persisted to H2 for future queries.

---

## 🗄️ Database

- **H2 In-Memory**: Perfect for dev/testing.
- **Console Access**: Visit `/h2-console` in dev mode.
- **Schema**: Auto-generated via Hibernate.
- **Sample Data**: Check `src/main/resources/import.sql` for initial inserts.

To switch to a persistent DB (e.g., PostgreSQL), update `application.properties`:
```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/animelist
```

---

## 🤝 Contributing

We love contributions! 🌈

1. Fork the repo
2. Create a feature branch: `git checkout -b feature/amazing-addition`
3. Commit changes: `git commit -m 'Add amazing feature'`
4. Push: `git push origin feature/amazing-addition`
5. Open a Pull Request

### Ideas for Contributions
- Add more rating sources (e.g., AniList API)
- Implement user reviews and personal scores
- Enhance scraping for more sites
- Add caching with Redis

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙌 Acknowledgments

- **Jikan API**: For MyAnimeList data
- **OMDB API**: For IMDb ratings
- **Rotten Tomatoes**: For critics' scores
- **Quarkus Team**: For the awesome framework

Made with ❤️ for anime fans everywhere!

---

*Ready to rate some animes? Let's get started! 🚀*
