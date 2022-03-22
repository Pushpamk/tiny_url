# Tiny URL - URL shortener application

***

URL shortener to reduce a long link.

<!-- Placeholder for badges https://shields.io -->
![Java 11](https://img.shields.io/badge/java-11-007396?style=flat-square&logo=java) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.4-6DB33F?style=flat-square&logo=spring-boot) ![Redis](https://img.shields.io/badge/Redis-6.2.6-DC382D?style=flat-square&logo=redis) ![MongoDB](https://img.shields.io/badge/MonogDB-5.0.6-47A248?style=flat-square&logo=mongodb)


## Prerequisite 
1. Java
2. Spring Boot
3. Redis 
4. MongoDB

## Usage
### Running Application  

`mvn spring-boot:run`  

### Creating user
Request  

```
curl --location --request POST 'localhost:8080/api/v1/user/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Pushpam Kumar"
}'
```
  
Response  

```
{
    "id": "6df4a87b-7aa7-4e62-9c7a-d9acfa400b9a",
    "name": "Pushpam Kumar",
    "apiKey": "54dae940a4c345859f5374e2e6c78638"
}
```
  
### Short url
**Creating short url**

Request
```
curl --location --request POST 'localhost:8080/api/v1/link/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "e6f09b6f-3486-4087-8d5d-b329725a3300",
    "apiKey": "d8883a80f9c74195b9955c39358ea523",
    "originalURL": "https://www.linkedin.com/in/pushpam-kumar/"
}'
```
> Note: if apiKey is incorrect, it will throw 403 status code

Response  
```
{
    "http://localhost:8080/eUyZG"
}
```

**Get original link from short link**

Request  
```
curl --location --request GET 'localhost:8080/api/v1/link/eUyZG'
```

Response  
```
{
    "https://www.linkedin.com/in/pushpam-kumar/
}
```