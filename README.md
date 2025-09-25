# gas-station-java-api

To run PostgreSQL in Docker:  
docker-compose up -d

To run project:  
mvn spring-boot:run

To run Swagger (API DOCS):  
http://localhost:8080/swagger-ui/index.html

To open database:  
docker exec -it postgres_db psql -U admin -d gas_station_db

\dt → list tables  
\d users → show structure from users table  
SELECT * FROM fuel_pump; → show data