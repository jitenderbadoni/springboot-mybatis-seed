# springboot-mybatis-seed
## Spring Boot + Swagger + Mybatis + MySQL
#### Project having basic Database CRUD operation with Mailer Functionality


### Before moving to setup instruction make sure you've setup Java and Maven


#### Setup Instruction 
1. Pull project in your local system.
2. Run Database script `test_db.sql` in MySQL database client
3. Move to project's root directory 
4. Configure Your email address at `src/main/resources/application.properties` and database connection `src/main/resources/jdbc.properties`
5. Enter your email address at `/project/src/main/java/com/rest/project/ApplicationConstants.java`
5. Run `mvn spring-boot:run`
6. Open browser hit `http://localhost:8080`
7. You must see `Welcome to Spring Application` message on browser and a mail will be triggered

#### Few other methods are available, methods details is available in swagger
1. `/allUsers`
2. `/getUserById`
3. `/insertUser`
4. `/updateUser`

#### To Use Swagger

Hit `http://localhost:8080/swagger-ui.html` on browser


### Enjoy!
