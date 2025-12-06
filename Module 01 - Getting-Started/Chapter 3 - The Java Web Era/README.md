# java wev era
as we discussed earlier how java became popular due to its **portability , Security and Auto memory Management** . this time is to came in usage in web era....
Hence , java started it's journey from -

## Java Servlet (1997)
*Servlet is a java class inside a server which process dynamic request and generate a response .*

as earlier in languages such as **c/c++** what we need to do is - first have to code than connect it with a server to setup a system to process a request and generate response .

what java programmers thinks ? why to do a extra step to setup server ? 

**Why not to code inside a server?**

hence develop a solution **Servlet**

Which is -

> Servlet is a java class inside a server which process dynamic request and generate a response .
> 
But still having a problem !!

There is no separation between logic and presentation . inside a servlet class programmer is writing both a dynamic html page + bussiness logic as well .
this is looking messy and considered as bad programming .

hence a new concept take birth that is -

## JSP (1999)
> Java Server Page

*Jsp is a html page which allows programmer to write java program inside special tags.*

now programmers are start to wright backend code in servlet class and for presentation using jsp.

but still there is a mixing of html with java code .

as inside tags a lot of java code mixed with html.

thus next we have -

## EJB (2000-2003)
> Enterprise java beans
 
it resolve the limitations of Jsp but it is too complex , confusing and a hard configurartion of xml needed .

Thus in 2003 The master Introduced as **SPRING** came in existence.

## Spring (2003)
spring Introduced major 3 concepts which revolutes boom in the market -

**IOC , Dependency Injection , and Spring Container**

 which automate lot of work as now programmer have to think more on logic not more on confuguration .

 but still there is problem -

 - more than 100+ xml files,
 - no embedded server ,
 - no auto configuration ,
 - no starter dependencies .

thus Springboot came in the field -

## SpringBoot - (2014)
A robust Framework to design a Web Application with minimum efforts efficiently having -

- auto configuration @SpringBootApplication
- Embedded Tomcat Server
- Starter Dependencies
- Loose Coupling

