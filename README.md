# CookWithMeApi
CookWithMeApi is a REST API designed for sharing cooking recipes. Guests can access available recipes and categories, while registered users have the ability to add their own recipes and manage them. The application features a JWT-based authentication system.
## How to run
To run app you need maven and docker.
1. Ensure that connection string in application.properties file is correct
```
spring.datasource.url=jdbc:postgresql://db:5432/
```
2. Clone the repository
```
git clone https://github.com/MarcelBadek/CookWithMeApi.git
```
3. Build .jar file
```
mvn install
```
4. Build docker container
```
docker compose up --build -d
```
You can access app at the following URL: http://localhost:8080/api/v1.