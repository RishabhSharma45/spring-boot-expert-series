# SpringBoot

## Why SpringBoot ?
as spring having problems such as - 

- manual configuration
- heavy xml
- slow deployment
- External Server needed

thus SpringBoot provides Solution such as -

- less Boilerplate

  as added Start dependecies . eg. Starter-Web-Dependency consists of Spring MVC , Jackson , Logging (logback) , validation and embedded server. thus no need to add dependecies for them externally.
  
- auto Configuration
- embedded server

  Tomcat
  
- fast deployment
  
  as having production ready features such as - actuator/health etc.

  ---

## Anatomy of SpringBootApp -
### Spring Boot Starter
what is Starter - a pre made dependency bundle.
eg. springboot - starter - web
   conatining - spring mvc , jackson(JSON) , validation , Logback , embedded tomcat.
### @SpringbootApplication
consist of - **@Configuration** - java based Configuration + **@EnableAutoConfiguration** - auto register needed bean + **@ComponentScan** - all @Component , @Service , @Repository and @Controller scanned by this .


 
