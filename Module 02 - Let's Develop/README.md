# Let's develop and Know basics of Springboot-

## RestController V/S Controller
Controller handles httpRequest and send back response to client in html/jsp dynamic pages.

whereas RestController is a annotation made of @Controller + @ResponseBody where it send back response in json/text format.

## GetMapping
GetMapping is sort form of @RequestMapping(method = RequestMethod.Get , value = "/hello")

instead of writing this long mapping to get a request @RequestMapping(method = RequestMethod.Get , value = "/hello") just use - @GetMapping.

## DispatcherServlet
dispatcher servlet helps in comminication between client and server . as get request and send response. it is a **Request Handling Engine**

## ComponentScan
detect @Controller , @Repository , @Service an @Component

## AutoConfig 
it automate auto java configuration via annotation @EnableAutoConfiguration - which inject all needed beans.

## Application Entry 
SpringApplication run.

## Endpoints 
- @GetMapping
- @PostMapping
- @PatchMapping
- @PutMapping
- @DeletMapping

## Some Entity Related Annotations -
@Entity , @Table(name = "***") , @Data , @NoArgsConstructor , @AllArgsConstructor , 

@ID @GeneratedValue(Strategy = GenerationType.Identity)

## POM (Project Object Model)
1. Xml Header {Version Encoding}

2. Project Tag {Maven Configurartion}

3. Model Version {always 4.0.0} mostly not changes

4. parent section - containing default dependencies version , plugins and build settings.

5. project coordinate -

   groupId - domain of company

   artifactId - name of project

   Version - 0.0.1 working in progress , 1.0.0 final.

6. Name and description

7. properties - conating java version

8. dependencies and dependency

9. build setting

Q. What is Scope ?

there are 6 type of scope in java which tells where and when a dependency will use

1.compile , 2.runtime , 3.test , 4.provided , 5.system

Q. What is Optional ?

is this dependency will added in different machine or not ..

## @Repository did what magic ?
it is a spring StereoType , Dependency Injection bean creation

it extends JpaRepository - interface provides spring data jpa .

- Repository (Marker Interface)
              |
- CrudRepository (all methods of crud)
              |
- PagingAndSortingRepository (findAll(pageable),findAll(Sort))
              |
- JpaRepository (all came inside it above repositories as well <Employee , Int>)

## MySql Connect - application.properties
Spring.datasource.url = jdbc:mysql://localhost:3306/db_name?usessl=false$serverTimeZone=UTC

Spring.datasource.password = root

Sprinf.datasource.username = root

than - connect dialect , and do spring.jpa.hibernate.ddl-auto = update

## some more imp annotations -
@RequestBody Employee employee (to get employee from json from frontend (request))

@RequestParam and @Param -- ?email=**

@PathVariable /email/***

## SpringbootApplicationTest
default class for testing

starter test dependency needed.

## validation 
add dependency - starter validation
- @NotBlank
- @Email
- @MAX
- @MIN
- @NotNull   @Valid add in constructor.....

## Custum Error Response
1. Custom Exceprion Class

2. Error Response

3. GlobalExceptionalHandler

   @ControllerAdvice and @ExceptionalHandles(____.class) throw this Exception...

## Dto v/s Entity , Logger and @Query (value = ?1 ?2 , nativeQuery = true);
public static final Logger logger = loggerFactory.getLogger(___.class)

logger.info/debug/error.....


   


