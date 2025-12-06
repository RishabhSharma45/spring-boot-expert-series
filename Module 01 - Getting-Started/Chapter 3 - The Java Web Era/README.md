#The Java Web Era

🌍 Pehle Web Kaise Chalti Thi?

Web sirf static pages hota tha → HTML

User input ya database interaction = ❌ Impossible

Agar kuch dynamic chahiye hota → CGI (Common Gateway Interface)

but problem with cgi is - 
it is slow , heavy , no portability and limited scalability . 
means - Har request ke liye new process banti thi 😑 ,
        Process create/destroy time lagta
        Mostly C/C++ → portability kam
        Traffic badh jaye to server down 🚨

Java Engineer Ne Bola: 
    "Yaar ek aisa program banate hain jo server ke andar hi chale aur multiple requests kaam kar le bina baar baar new process banaye!"
    Aur iss thought se janam hua…...

i. 🚀 Servlet — Java Ka Dynamic Web Hero

Servlet is a Java class that runs inside the Web Server and handles dynamic requests (user interaction, database calls, etc.)

🧠 Key Concept:

Server = Container (Tomcat, Jetty, etc.)

Servlet = Server-side Java program

Input = HTTP Request

Output = HTML/JSON/XML/Response

diffenerence between CGI and Servlet -

| Feature               | CGI                       | Servlet                                |
| --------------------- | ------------------------- | -------------------------------------- |
| Performance           | ❌ Slow                   | ✅ Fast                               |
| Process Handling      | Har request = new process | Ek hi Java thread reuse                |
| Platform Independence | ❌ Kam                    | ☑ Pure Java = fully portable          |
| Scalability           | Limited                   | High                                   |
| Persistence           | Nahi                      | Servlet **memory me loaded** rehta hai |

high level flow -
User → Browser → HTTP Request → Servlet Container (Tomcat) → Servlet Code → Response → Browser

🐍 CGI Example (Old Style — C/C++ ya Perl)

CGI program in C (login handling type example)
#include <stdio.h>
#include <stdlib.h>

int main() {
    char *data = getenv("QUERY_STRING"); // URL se input lena
    printf("Content-type:text/html\n\n");
    printf("<html><body>");
    printf("<h2>User Data: %s</h2>", data);
    printf("</body></html>");
    return 0;
}

❌ CGI mein kya dikkat thi?

Har request pe new process create

Server heavy load mein mar jaata 😵

Memory waste

Portability nahi (Windows pe alag, Linux pe alag code)

☕ Java Servlet Example (Same Feature — Request Read)

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");

        out.println("<html><body>");
        out.println("<h2>User Data: " + name + "</h2>");
        out.println("</body></html>");
    }
}
| Feature                 | CGI (C code)              | Servlet (Java code)             |
| ----------------------- | ------------------------- | ------------------------------- |
| Request Handling        | Query string manual parse | `req.getParameter()` — built-in |
| New Process per Request | Yes ❌                     | Thread reuse ✔                  |
| Speed                   | Slow ❌                    | Fast 🚀                         |
| Security                | Kam                       | Strong                          |
| Platform Dependent      | Haan ❌                    | Pure Java ✔ Portable            |
| Server Memory           | Zyada waste               | Efficient                       |

⭐ Biggest Servlets Benefits (One-Liners for Interview)

Thread-based → performance boost

Server ke andar hi chalta → process creation overhead nahi

Built-in APIs → Request, Response, Sessions, Cookies — sab easy

Automatic memory management (JVM)

Write Once, Run Anywhere 🏆



🌍 Web Server vs Application Server — Real Seedhi Baat
| Feature         | Web Server 🌐             | Application Server 🏭        |
| --------------- | ------------------------- | ---------------------------- |
| Kaam            | Static content serve      | Dynamic business logic       |
| Example Content | HTML, CSS, Images         | Servlets, EJB, DB Operations |
| Java Support    | Nahi ya limited           | Full Java EE support         |
| Examples        | Apache HTTP Server, Nginx | JBoss, WebLogic, WebSphere   |
| Load Handling   | Simple                    | Heavy, enterprise apps       |

💡 Simple Analogy

Web Server
🍽 “Waiter” — Sirf order leke khana laata

Application Server
👨‍🍳🤵 Chef + Waiter dono — Khana banata bhi & serve bhi karta

☕ Tomcat Kahan Aata Hai?

Tomcat neither fully Web Server
Nor fully Java EE Application Server

Ye ek Servlet Container + Web Server hai 😎
Yani ki it handles:

✔ Servlets
✔ JSP
✔ HTTP requests
✔ Connection threads

🧠 Servlet Container Kya Hota Hai?

A component inside server that loads, manages & runs Servlets

Java “web era” me Servlet Container was THE HERO 🤘

Servlet container karta kya hai?

Servlet ko load karna

Request/Response manage karna

Lifecycle control

Threads allocate karna

Security handle karna

Aur ye sab automatically 🔥
Developer ko chinta nahi hoti


🕰 Pehle Kaise Kaam Hota Tha?
Developer Ki Zindagi:

1️⃣ Tomcat server download
2️⃣ Apache Tomcat → ZIP extract
3️⃣ JAVA_HOME environment variable set
4️⃣ CATALINA_HOME set
5️⃣ Tomcat: bin/startup.sh or startup.bat
6️⃣ WebApp banana → WAR file banana
7️⃣ WAR ko webapps/ folder me daalna
8️⃣ Browser: http://localhost:8080/appname

Aur phir Servlet chalti thi 🥹

🔄 WAR File Kya Hoti Hai?

Java web apps ko package karne ka format:

📦 Web ARchive = WAR

Contains:

/WEB-INF
   /classes (Servlet .class files)
   /lib (JARs)
   web.xml (deployment descriptor)
HTML/JSP files

❤️ Today Ka Scene?

Spring Boot**:
→ Tomcat ko embed kar diya app ke andar hi 😍
→ No WAR, no server setup
→ Just mvn spring-boot:run 🏎💨

Yani:

Servlet concept → exists

Lekin manual jhanjhat ○ khatm

now thinks in depth - 

📦 Pehle Socho — Packaging Kyun Zaroori Hai?

Tum Java project banate ho → But woh system me kaisе chale?
To final product ko ek file me pack kiya jaata hai jisme:

✔ Code
✔ Libraries
✔ Resources
✔ Configurations

Sab ek single package me → easy to deploy! 😎

☕ JAR (Java ARchive)
📌 Where used?

Java Normal Applications / Libraries ke liye

JAR Contains:
/com/myapp/*.class
META-INF/MANIFEST.MF
libraries (optional)
resources

💻 Run kaise?
java -jar myapp.jar


📌 Self runnable (agar MANIFEST me Main-Class diya ho)

🌐 WAR (Web ARchive)
📌 Where used?

Web Applications ke liye (Servlet, JSP, HTML, CSS, JS)

Specifically Servlet Container / Web Server (Tomcat) me deploy hoti hai

WAR Contains (strict structure):
MyWebApp.war
 ├── index.html / JSPs
 ├── CSS / JS / Images
 └── WEB-INF
       ├── classes (Servlet compiled code)
       ├── lib (JAR dependencies)
       └── web.xml (deployment descriptor)


📌 WAR only Web Server run karega
You cannot run WAR directly from command line ❌
Deployment:
→ Bas WAR file ko Tomcat me daaldo → Website RUN 😎

🧘 Why WAR was used earlier?

Pehle:

Tomcat separately install karna hota tha

.war banake deploy folder me drop krna hota

Ye process time consuming ⏳
Deployment me error hoti rehti 😅

⚡ Today Ka Magic — Spring Boot

Spring Boot ne Tomcat ko app ke andar pack kar diya 😍
Isliye ab mostly .jar hi bana kar run kar dete hain!

Example:

mvn clean package
java -jar myapp.jar


Aur website khulti hai:

http://localhost:8080

🛠️ Step 1️⃣ — New Dynamic Web Project Create Karna

📌 Eclipse → File → New → Dynamic Web Project

👉 Project Name: HelloRishabhServlet
👉 Target Runtime: Apache Tomcat (choose your installed Tomcat)
👉 Configuration: Default rakho
✔ Finish ✔

🔥 Ho gaya tera Java web project ready!
Eclipse ne tere liye yaha ye bana diya:

HelloRishabhServlet/
 ├── src/main/java
 ├── WebContent/
 │    ├── WEB-INF/
 │    │    └── web.xml
 └── ...

📄 Step 2️⃣ — Servlet Class Add Karna

📌 Right-click src/main/java → New → Servlet
Class Name: MyFirstServlet

Ye code dal:

package com.rishabh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // browser ko bol rahe: jo bhej raha hun wo HTML hai
        response.setContentType("text/html");

        // PrintWriter se hum browser me output bhejenge
        PrintWriter out = response.getWriter();

        // HTML response
        out.println("<h1 style='color:purple;'>Hello Rishabh Bhai! 😎</h1>");
        out.println("<p>Yeh tera pehla servlet chal gaya 🚀</p>");
    }
}

🧠 Line-by-Line Samajh Lo:
Code	Meaning with Swagger 😎
extends HttpServlet	Servlet banna aur server ke rules follow karna
doGet(...)	Browser GET request ko handle karega
setContentType("text/html")	Browser ko bol: “HTML bhej raha hun bhai!”
PrintWriter	Output stream jisse hum browser me HTML print karte
out.println(...)	Actual HTML UI 😍
⚙️ Step 3️⃣ — web.xml me mapping (Route set karna)

📌 WebContent/WEB-INF/web.xml open karo aur yeh mapping add karo:

<servlet>
    <servlet-name>myservlet</servlet-name>
    <servlet-class>com.rishabh.servlet.MyFirstServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>myservlet</servlet-name>
    <url-pattern>/rishabh</url-pattern>
</servlet-mapping>


🧠 Yeh kya karta?

Tag	Kya karta hai
<servlet-name>	Naam diya servlet ko
<servlet-class>	Class kahan rakhi hai system ko bataya
<url-pattern>	Kaunse URL par access hoga — Routing
🚀 Step 4️⃣ — Run on Server

📌 Project pr right-click → Run As → Run on Server
Tomcat select karo → Finish

Browser URL me jao:

http://localhost:8080/HelloRishabhServlet/rishabh


🎉🎉 Output:

Hello Rishabh Bhai! 😎
Yeh tera pehla servlet chal gaya 🚀

Ab aate hain Servlet Lifecycle pe — yaha REAL GAME START hota hai! 🎮🔥

Servlet ka lifecycle matlab:

Server servlet ko kaise janam deta, chalata aur maar deta hai 😄

Servlet ke lifecycle me 3 main methods hote hain:

1️⃣ init() → “Janam” 👶
2️⃣ service() → “Kaam-Dhanda / Duty” 🕶️
3️⃣ destroy() → “The End” ⚰️

🚦 Servlet Lifecycle Flow (Easy Hinglish Version)

Jab first request aati hai:

① Class Load hoti
▶ Server servlet ki class ko memory me load karta

② Object banega
▶ Sirf ek hi object banta poori app ke liye (singleton jaisa)

③ init() call hota
▶ Servlet initialize hota
▶ Ye sirf ek baar call hota

Jab multiple user requests aayengi:

④ service() call hota baar baar
▶ Request type check karta
▶ Agar GET request → doGet()
▶ Agar POST request → doPost()

💡 service() = Traffic controller 🚦
(doGet / doPost = kaam karne wale worker 😎)

Jab server band ho raha ho / app undeploy ho rahi ho:

⑤ destroy() call hota
▶ Resources free kar deta
▶ Database connections close
▶ Memory cleanup 🧹

🧾 Lifecycle Summary Diagram
Request Aayi? → Nahi → Kuch nahi

Yes →
Class Load → Object Create →
init() → service() → service() → service() →
.
.
. (multiple requests)
.
destroy()

🧠 Practical Example Code
public class MyLifeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Init: Servlet Janam le raha hai 😎");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Service: Kaam chal raha hai 🚀");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy: Alvida dosto 😢");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Hello Rishabh! 🚀");
    }
}

🎤 Ek Dialogue yaad rakhne ke liye

“Servlet paida ek baar hota hai, kaam hazaar baar karta hai, aur marta bhi ek baar hi hai!” 😎🔥

👍 Key Interview Points
Concept	Short & Sweet
init()	Sirf ek baar call hota, initialization ke liye
service()	Har request ko handle karta
doGet/doPost	service() inko call karta request type ke hisaab se
destroy()	Servlet band hone se pehle clean-up    

Ab aaye Deployment Descriptor (web.xml) pe — Servlet world ka Dil + Dimag 🧠❤️

📌 Deployment Descriptor = web.xml

✔ Java Web App ka configuration file
✔ Batata hai server ko kis servlet ko kis URL par chalana hai
✔ WEB-INF folder me hota hai

👉 Isse tu bol sakta hai:

“web.xml is like a map for servlets.”
Kis raste (URL) se kis servlet tak pahunchna hai! 🌍➡️🚪

🗂️ Location
WebContent/
  └── WEB-INF/
       └── web.xml

🧠 web.xml me kya kya likhte?
Web.xml Section	Kaam
<servlet>	Servlet ka naam + class link karta
<servlet-mapping>	Kis URL pattern se access hoga
<context-param>	Global configuration values
<welcome-file>	Default page jab server start ho
<error-page>	Custom error handling
🔥 Most Important — Servlet Mapping

Example for our Servlet 👇

<servlet>
    <servlet-name>myservlet</servlet-name>
    <servlet-class>com.rishabh.servlet.MyFirstServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>myservlet</servlet-name>
    <url-pattern>/rishabh</url-pattern>
</servlet-mapping>


🎯 Iska matlab:

➡ URL hit:
/rishabh
👉 Server: “Chal bhai MyFirstServlet chalao!”

🎯 Other Useful web.xml Tags
Default Home Page
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
</welcome-file-list>


Jab website khole:
✔ / → Automatically index.html open ho jayega

Error Handling
<error-page>
    <error-code>404</error-code>
    <location>/error404.html</location>
</error-page>


Agar page nahi mila → Cute error page 😁

Context Parameters (Global variables)
<context-param>
    <param-name>dbUser</param-name>
    <param-value>root</param-value>
</context-param>


🧠 Database ya email config by default yahi likhte the (Spring se pehle)

🚀 Short Summary For Interview
Point	Remember
File Name	web.xml
Folder	WEB-INF
Purpose	Server configuration + Routing
Must Know	<servlet> + <servlet-mapping>
Old Era	Servlet config web.xml me hoti thi
New Era	Annotation based (e.g. @WebServlet) in Servlet 3.0+
✨ Premium Dialogue to Remember

“web.xml bolta hai — kis darwaze par knock karoge, kaunsa banda (servlet) khulega.” 😎🔑🚪    


🔥 Why Annotation?

Purane time me har servlet ke liye web.xml me 8–10 line likho… boring & time waste 🥱
Ab:

✔ Faster development
✔ No XML headache
✔ Readability ↑
✔ Less files, less config
✔ Code aur configuration saath-saath 😍

⚙️ Servlet 3.0+ Annotation — @WebServlet

Example 👇

package com.rishabh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rishabh")
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Servlet without web.xml 💥</h2>");
        out.println("<p>Rishabh Bhai, Annotation ne khel badal diya! 🔥</p>");
    }
}

🧠 What did we just do?
Feature	XML Era	Annotation Era
Mapping	web.xml required	Only @WebServlet
Config visibility	Different file	Same class → easy
Project size	More files	Reduced
Speed	Slow setup	Fast & clean
💪 Useful Options in @WebServlet

You can use multiple URL routes:

@WebServlet(urlPatterns = {"/one", "/two"})


Load servlet at startup:

@WebServlet(urlPatterns="/test", loadOnStartup=1)


Init params:

@WebServlet(
    urlPatterns="/db",
    initParams = {
        @WebInitParam(name="user", value="root"),
        @WebInitParam(name="pass", value="1234")
    }
)


🧠 Ab servlet ke constructor jaisa config mil gaya → web.xml ki jarurat nahi!

🔥 Short Interview Pointers
Question	Solid Answer
Servlet mapping kahan hota hai?	@WebServlet annotation or web.xml
Servlet 3.0 introduced what?	Annotation-based config + Pluggability
What is Pluggability?	Servlets without web.xml

🚦 HTTP Servlet Request & Response

Web ka communication request-response model pe chalta hai:

Client bheje Request → Server bheje Response
Yeh cycle chalta hi rehta hai 🔁 😎

1️⃣ HttpServletRequest → Client ki taraf se jo aata hai 🌐➡️🛠️

User ne kya bheja?

✔ Data (Form data / URL params)
✔ Browser info
✔ Method (GET/POST/PUT…)
✔ Cookies
✔ Headers
✔ IP Address
✔ File Upload

🧠 Ye object bana ke Tomcat servlet ke paas deta hai.

Top Request Methods
request.getParameter("name");   // Input value
request.getMethod();            // GET or POST
request.getRequestURI();        // URL path
request.getHeader("User-Agent");// Browser details
request.getCookies();           // Cookies array
request.getRemoteAddr();        // Client IP

2️⃣ HttpServletResponse → Server ki taraf se jo jata hai 🛠️➡️🌐

Server kya bhej sakta hai?

✔ HTML content
✔ File download
✔ JSON response
✔ Cookies set
✔ Headers set
✔ Redirects

Response ke superpowers
response.setContentType("text/html"); // Browser ko batao content type
PrintWriter out = response.getWriter();
out.println("Hello Response 🚀");

🧠 Example — Combining Both

Form se naam bheja & response me show kiya:

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    
    resp.setContentType("text/html");

    String name = req.getParameter("username");

    PrintWriter out = resp.getWriter();
    out.println("<h2>Welcome " + name + " 💫</h2>");
}

🎯 Interview Style Points
Feature	Request	Response
Direction	Client → Server	Server → Client
Carries	Input data, metadata	Output, status, headers
Main methods	getParameter(), getHeader()	setContentType(), getWriter()
Creation	Container creates	Container creates
Used in	doGet/doPost	doGet/doPost
🧩 Small Trick

Request = “Mujhe ye chahiye” 🤲
Response = “Lo bhai mil gaya” 🎁

⭐ Bonus Knowledge (Points Bada Denge!)
Topic	2 line crisp
MIME Type	Inform browser what kind of data (text/html, app/json)
Status Codes	200 OK, 404 Not Found, 500 Server Error
Encoding	UTF-8 for global language support
✨ Ek Rapchik Dialogue Yaad Rakh

“Request aati hai tab duniya chalti hai, Response jaata hai tab result dikhta hai!” 😎🔥   


1️⃣ HTTP GET vs POST – Antar
Feature	GET	POST
Request Body	Nahi (data URL me jata)	Haan (data body me jata)
URL Length	Limited (~2000 chars)	Unlimited practically
Visibility	URL me sab dikhega	Browser URL me nahi dikhega
Use Case	Data fetch / retrieve	Data submit / create / update
Idempotent?	Haan (repeat safe)	Nahi (repeat may create duplicates)
Cacheable?	Haan	Usually Nahi
Example	http://site.com?user=rishabh	Form submit with hidden data

🔥 Trick yaad rakh:

GET = Chhota aur safe fetching
POST = Bada aur secret data submit karna

2️⃣ doGet() vs doPost() – Internals
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    response.getWriter().println("GET Request Received 😎");
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    response.getWriter().println("POST Request Received 🔥");
}


Internals:

service() method decide karta hai ki GET → doGet(), POST → doPost()

doGet() = Mostly read operations

doPost() = Mostly write operations

3️⃣ Form Handling – GET & POST Example
HTML Form (GET)
<form action="rishabh" method="GET">
  Name: <input type="text" name="username">
  <input type="submit">
</form>


Browser URL me dikhega:

http://localhost:8080/rishabh?username=Rishabh

HTML Form (POST)
<form action="rishabh" method="POST">
  Name: <input type="text" name="username">
  <input type="submit">
</form>


Data hidden in request body, URL clean

Security & big data submissions ke liye best 😎

4️⃣ Query Params vs Body Params
Feature	Query Params	Body Params
Location	URL	Request Body
Max Size	~2000 chars	Practically Unlimited
Visibility	URL me	Hidden
Method	Mostly GET	Mostly POST
Use Case	Search / Filter	Form submit / File Upload

Example GET:

http://site.com/search?q=java


Example POST:

Body: { "username": "rishabh", "pass": "123" }

5️⃣ Redirect vs Forward (Servlet World)
Feature	Redirect	Forward
Browser URL	Change ho jata	Same rahta
Client request	Naya request karta	Same request pass
Server load	Extra request → thoda zyada	Efficient, server side hi handle
Use Case	Login success → dashboard	Servlet to JSP data pass
Example Servlet Redirect
response.sendRedirect("dashboard.jsp");

Example Servlet Forward
RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
rd.forward(request, response);

















