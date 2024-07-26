# CRUD TO MANAGE BOOKS

I have developed a CRUD in Spring Boot to manage books, implementing a RESTful API that follows REST design principles. 
It uses the appropriate HTTP verbs (GET, POST, PUT, DELETE) to perform the CRUD operations, and has efficient error 
handling that provides clear messages and HTTP status codes reflecting the result of each operation, related to custom 
validations to ensure that the data is correct and error-free, using the Data Transfer Object (DTO) design pattern. 
In addition, I have performed extensive testing with Postman to ensure the correct operation of all endpoints.

## What tools have I used?
1. Java - Spring Boot
2. Postman
3. MySQL Workbench
4. Vscode

## Dependencies used
1. Spring Boot
2. Spring Data JPA
3. Spring Boot Dev Tools
4. Spring Web
5. Validation
6. Lombok
7. H2 Database

## Testing endpoints with Postman:
1.  GET /books: 
Method: GET 
URL:  http://localhost:8080/books
    
2.  GET /books/{id}: 
Method: GET 
URL:  http://localhost:8080/books/1 
Verify that you receive the details of a specific task.
    
3.  POST /books: 
Method: POST 
URL:  http://localhost:8080/books 
Body (JSON): 
{ 
"title":  "El Arte de la Guerra",
"author":  "Sun Tzu",
"Gender":  "Clásico",
"yearPublication":  "1772-01-01"
}
    
4.  PUT /books/{id}: 
Method: PUT 
URL:  http://localhost:8080/books/1
Body(JSON): 
{ 
"title":  "El Arte de la Guerra",
"author":  "Sun Tzu",
"Gender":  "Clásico",
"yearPublication":  "1772-01-01"
} 

5.  DELETE /books/{id}:
Method: DELETE 
URL:  http://localhost:8080/tasks/1
