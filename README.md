# 🔐 Spring Boot + Spring Security + JWT + PostgreSQL

A secure authentication boilerplate built with **Spring Boot**, **Spring Security**, **JWT (JSON Web Token)**, and **PostgreSQL**.  
This project provides a ready-to-use setup for modern backend APIs with token-based stateless authentication.

---

## ✨ Features

- ✅ Secure login with **username & password**
- 🔐 JWT-based stateless authentication
- 🧠 Passwords hashed using **BCrypt**
- 🔎 Validates JWT on every protected request
- 🔄 Token authentication through custom filters
- 🗃️ Integrated with **PostgreSQL** using Spring Data JPA
- 🚀 Easily extensible for any microservice or REST API

---

## 🧱 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT (jjwt)
- PostgreSQL
- Maven

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/KshitijD21/Spring_PostgreSQL_Auth.git
cd Spring_PostgreSQL_Auth 
```

### 2. Configure Environment Variables

You can either create a .env file.

    SECURITY_USER=xyz
    SECURITY_PASS=xyz
    DB_USER=xyz
    DB_PASS=xyz

### 3. Run the app

```bash
./mvnw spring-boot:run
```

---

## 🔐 Auth Flow Summary

  Login → /auth/login

  - Credentials passed to LoginAuthFilter

  - Verified via AuthenticationManager and UserDetailsServiceImpl

  - On success, JwtUtil generates a signed JWT

  - Token returned to the client

  Access Protected APIs

  - Client includes token in Authorization: Bearer <token> header

  - JwtAuthenticationFilter validates the token

  - Valid user stored in SecurityContextHolder

  - Secured controller endpoints can now access authenticated data

---

## 🧠 Use Cases

  Backend APIs for mobile or web apps

  Admin dashboards or CMS systems

  Authentication microservices

  Any app needing fast, secure login setup


--- 

## 🧑‍💻 Author

Kshitij D.
📍 Arizona State University
🔗 [LinkedIn](https://www.linkedin.com/in/kshitij-dumbre-1b6870175/)

