# 🎬 JR Hibernate Project 2  

A **training project** demonstrating how to work with **Hibernate ORM** on top of a movie database schema (similar to **Sakila**).  
It covers core rental-service scenarios: customer registration, renting and returning films, accepting payments, adding new titles, and auditing the database design.

---

## ⚙️ Tech Stack
| Technology          | Version  | Purpose                        |
|---------------------|----------|--------------------------------|
| Java                | 14       | Programming language           |
| Maven               | –        | Build & dependency management  |
| Hibernate ORM       | 7.0.x    | JPA implementation             |
| Jakarta Persistence | 3.x      | JPA specification              |
| MySQL Connector/J   | 9.x      | Database driver                |
| P6Spy               | 3.9.x    | SQL query logging              |
| Lombok              | 1.18.x   | Boilerplate code generation    |
---

## 🗃️ Project Structure
```
src/main/java/dev/subotinov/
 ├── config/        // JPA utilities and configuration
 ├── entity/        // entities for the movie schema
 ├── repository/    // DAO/repository layer
 ├── service/       // business logic grouped by domain
 └── util/          // converters and enums

src/main/resources/META-INF/
 └── dump-hibernate-2.sql   // MySQL dump for local setup
 └── persistence.xml        // DB connection & entity mapping
```

---

## ✅ Completed Tasks
- **Environment setup**
  - Imported the MySQL dump.
  - Created the Maven project with P6Spy logging.
- **Database connection & exploration**
  - Connected the local DB as a Data Source in the IDE.
  - Built ER diagrams and mapped entities.
- **CRUD & transactional scenarios**
  - ✳️ *Create customer*: transactional method persisting `Customer` and `Address`.  
  - ✳️ *Return movie*: closes an active `Rental` by setting `return_date`.  
  - ✳️ *Rent with payment*: customer rents available `Inventory`, creating `Rental` and `Payment`.  
  - ✳️ *Add new film*: creates `Film` and related entities (`Language`, `Actor`, `Category`, `Inventory`).  
- **DB structure review**
  - Missing FOREIGN KEY on `film_text.film_id → film.film_id`.  
  - `store.manager_staff_id` should be unique (one manager per store).  
  - `customer.email` should have a unique index.  

---

## 🚀 Getting Started
### 1. Import the database
```bash
mysql -u root -p < dump-hibernate-2.sql
```

### 2. Check configuration
- `persistence.xml`:  
  `jdbc:p6spy:mysql://localhost:3306/movie`  

### 3. Build & Run
```bash
mvn clean package
java -jar target/JavaRush-Hibernate-Project-1.0-SNAPSHOT.jar
```

---

## 📌 Next Steps
- Increase unit and integration test coverage.  
- Introduce DTOs and mapping (ModelMapper already included).  
- Add REST controllers for frontend interaction.  
- Implement database migrations (Flyway or Liquibase).  

---

## 📛 Conventional Commits
This project follows the [Conventional Commits](https://www.conventionalcommits.org/) specification for commit messages.

Examples:
- `feat: implement PlayerRepositoryDB CRUD methods and init.sql data script`
- `refactor: add JPA annotations to Player entity`
- `fix: resolve detached entity issue in RentalService`

---

## 📞 Contact
👤 **Author:** Yuriy Subotinov  
🔗 [GitHub](https://github.com/CrapMind)
🔗 [LinkedIn](https://linkedin.com/in/yuriy-subotinov-566069319)  
✉️ yuriy.subotinov@gmail.com  
