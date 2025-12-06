# 🌐 Chapter 3: The Java Web Era - Servlet

## 🌍 How the Web Used to Work?

In the early days, the web was mostly **static pages** → HTML only.  

- User input or database interaction? ❌ Impossible  
- Dynamic content? ❌ Hard  

To handle dynamic content, people used **CGI (Common Gateway Interface)**.  

But CGI had major problems:

- Every request created a **new process** 😑  
- Process creation & destruction took time  
- Mostly written in **C/C++**, so low portability  
- High traffic → server could crash 🚨  

---

## 💡 The Java Solution

Java engineers thought:

> "Let's build a program that runs **inside the server**, handles multiple requests, and **doesn't create a new process each time**!"  

And from this idea, **Servlets** were born… 🚀

---

## 🚀 Servlet — Java's Dynamic Web Hero

A **Servlet** is a **Java class** that runs inside a web server and handles **dynamic requests**:

- User interaction  
- Database calls  
- APIs, etc.  

**Key Concepts** 🧠:

| Component          | Role |
|-------------------|------|
| Server             | Container (Tomcat, Jetty, etc.) |
| Servlet            | Server-side Java program |
| Input              | HTTP Request |
| Output             | HTML / JSON / XML / Response |

---

## ⚡ CGI vs Servlet

| Feature               | CGI                        | Servlet                                |
|-----------------------|----------------------------|---------------------------------------|
| Performance           | ❌ Slow                    | ✅ Fast                               |
| Process Handling      | Every request = new process| ✅ Single Java thread reused          |
| Platform Independence | ❌ Low                     | ✅ Pure Java = fully portable         |
| Scalability           | Limited                    | ✅ High                               |
| Persistence           | ❌ None                    | ✅ Loaded in memory, stays active     |

---

User → Browser → HTTP Request → Servlet Container (Tomcat) → Servlet Code → Response → Browser


---

> Servlets brought **dynamic web apps** to Java in a fast, scalable, and portable way. 🌟


## 💻 CGI Example (Old Style — C/C++ or Perl)

```c
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
```

## ❌ CGI Issues:

- every request, new process create
- Heavy load → crash
- Memory waste
- Platform dependent

## ☕ Java Servlet Example (Same Feature)
```java
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
```

| Feature                 | CGI (C code)       | Servlet (Java code)             |
| ----------------------- | ------------------ | ------------------------------- |
| Request Handling        | Manual query parse | `req.getParameter()` — built-in |
| New Process per Request | Yes ❌              | Thread reuse ✔                  |
| Speed                   | Slow ❌             | Fast 🚀                         |
| Security                | Low                | Strong                          |
| Platform Dependent      | Haan ❌             | Pure Java ✔ Portable            |
| Server Memory           | Wasted             | Efficient                       |

---

# 🌐 Web Server vs Application Server — Straight & Clear

| Feature         | Web Server 🌐             | Application Server 🏭        |
| --------------- | ------------------------- | ---------------------------- |
| Role            | Serve static content      | Handle dynamic business logic|
| Example Content | HTML, CSS, Images         | Servlets, EJB, DB Operations|
| Java Support    | Limited / No              | Full Java EE support         |
| Examples        | Apache HTTP Server, Nginx | JBoss, WebLogic, WebSphere   |
| Load Handling   | Simple                    | Heavy, enterprise apps       |

---

## 💡 Simple Analogy

**Web Server**  
🍽 “Waiter” — Only takes orders and serves food  

**Application Server**  
👨‍🍳🤵 Chef + Waiter — Cooks and serves food  

---

## ☕ Tomcat Position

Tomcat is **not fully a Web Server** nor **fully a Java EE Application Server**  

It is a **Servlet Container + Web Server** 😎  

Handles:

✔ Servlets  
✔ JSP  
✔ HTTP requests  
✔ Connection threads  

---

## 🧠 What is a Servlet Container?

A **component inside the server** that loads, manages & runs Servlets  

### Responsibilities:

- Load Servlets  
- Handle Request/Response  
- Control Servlet lifecycle  
- Allocate threads  
- Manage security  

**All automatic 🔥 — Developer just writes code**  

---

## 🕰 Old Deployment Flow

1️⃣ Download Tomcat  
2️⃣ Extract ZIP → Apache Tomcat folder  
3️⃣ Set `JAVA_HOME`  
4️⃣ Set `CATALINA_HOME`  
5️⃣ Start Tomcat → `bin/startup.sh` or `startup.bat`  
6️⃣ Create WebApp → Package as **WAR**  
7️⃣ Drop WAR in `webapps/` folder  
8️⃣ Browser → `http://localhost:8080/appname`  

---

# 🛠️ Step-by-Step: Your First Java Servlet 🚀

## 🟢 Step 1️⃣ — Create a New Dynamic Web Project

1. **Eclipse → File → New → Dynamic Web Project**  
2. **Project Name:** `HelloRishabhServlet`  
3. **Target Runtime:** Apache Tomcat (choose your installed Tomcat)  
4. **Configuration:** Default  
5. Click **Finish** ✔  

🔥 Tera Java web project ready ho gaya!  

**Project Structure:**

HelloRishabhServlet/
├── src/main/java
├── WebContent/
│ ├── WEB-INF/
│ │ └── web.xml
└── ...


---

## 🟢 Step 2️⃣ — Add Servlet Class

1. Right-click `src/main/java` → **New → Servlet**  
2. **Class Name:** `MyFirstServlet`  

### Paste this code:

```java
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

        // Browser ko bol rahe: ye HTML bhej raha hun
        response.setContentType("text/html");

        // PrintWriter se hum browser me output bhejenge
        PrintWriter out = response.getWriter();

        // HTML response
        out.println("<h1 style='color:purple;'>Hello Rishabh Bhai! 😎</h1>");
        out.println("<p>Yeh tera pehla servlet chal gaya 🚀</p>");
    }
}
```

🧠 Line-by-Line Explanation
| Code / Keyword                            | Meaning 😎                                     |
| ----------------------------------------- | ---------------------------------------------- |
| `extends HttpServlet`                     | Servlet banna aur server ke rules follow karna |
| `doGet(...)`                              | Browser ki GET request ko handle karega        |
| `setContentType("text/html")`             | Browser ko bol: “HTML bhej raha hun bhai!”     |
| `PrintWriter out = response.getWriter();` | Output stream jisse hum HTML print karte       |
| `out.println(...)`                        | Actual HTML content 😍                         |

---

## ⚙️ Step 3️⃣ — web.xml Mapping (Set URL)

Open WebContent/WEB-INF/web.xml aur add karo:

<servlet>
    <servlet-name>myservlet</servlet-name>
    <servlet-class>com.rishabh.servlet.MyFirstServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>myservlet</servlet-name>
    <url-pattern>/rishabh</url-pattern>
</servlet-mapping>

🧠 Explanation:
| Tag               | Role                                 |
| ----------------- | ------------------------------------ |
| `<servlet-name>`  | Servlet ka naam                      |
| `<servlet-class>` | Class ka path system ko batata hai   |
| `<url-pattern>`   | Kaunse URL par access hoga — Routing |

---

## 🚀 Step 4️⃣ — Run on Server

Project pe right-click → Run As → Run on Server

Tomcat select karo → Finish

Browser me jao:

http://localhost:8080/HelloRishabhServlet/rishabh

---

> 🎉 Output:

Hello Rishabh Bhai! 😎
Yeh tera pehla servlet chal gaya 🚀

---
## Ab aate hain Servlet Lifecycle pe — yaha REAL GAME START hota hai! 🎮🔥

Servlet ka lifecycle matlab:

Server servlet ko kaise janam deta, chalata aur maar deta hai 😄

### Servlet ke lifecycle me 3 main methods hote hain:

- 1️⃣ init() → “Janam” 👶 
- 2️⃣ service() → “Kaam-Dhanda / Duty” 🕶️
- 3️⃣ destroy() → “The End” ⚰️

### 🚦 Servlet Lifecycle Flow (Easy Hinglish Version)

Jab first request aati hai:

① Class Load hoti
▶ Server servlet ki class ko memory me load karta

② Object banega
▶ Sirf ek hi object banta poori app ke liye (singleton jaisa)

③ init() call hota
▶ Servlet initialize hota
▶ Ye sirf ek baar call hota

### Jab multiple user requests aayengi:

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

### 🧠 Practical Example Code
```java
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
```

### 🎤 Ek Dialogue yaad rakhne ke liye

> “Servlet paida ek baar hota hai, kaam hazaar baar karta hai, aur marta bhi ek baar hi hai!” 😎🔥

---

> 👍 Key Interview Points
- Concept	Short & Sweet
- init()	Sirf ek baar call hota, initialization ke liye
- service()	Har request ko handle karta
- doGet/doPost	service() inko call karta request type ke hisaab se
- destroy()	Servlet band hone se pehle clean-up

---

## Ab aaye Deployment Descriptor (web.xml) pe — Servlet world ka Dil + Dimag 🧠❤️

### 📌 Deployment Descriptor = web.xml

- ✔ Java Web App ka configuration file
- ✔ Batata hai server ko kis servlet ko kis URL par chalana hai
- ✔ WEB-INF folder me hota hai

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

### Example for our Servlet 👇

```
<servlet>
    <servlet-name>myservlet</servlet-name>
    <servlet-class>com.rishabh.servlet.MyFirstServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>myservlet</servlet-name>
    <url-pattern>/rishabh</url-pattern>
</servlet-mapping>

```

### 🎯 Iska matlab:

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

### 🚀 Short Summary For Interview

Point	Remember
File Name	web.xml
Folder	WEB-INF
Purpose	Server configuration + Routing
Must Know	<servlet> + <servlet-mapping>
Old Era	Servlet config web.xml me hoti thi
New Era	Annotation based (e.g. @WebServlet) in Servlet 3.0+
✨ Premium Dialogue to Remember

> “web.xml bolta hai — kis darwaze par knock karoge, kaunsa banda (servlet) khulega.” 😎🔑🚪    


## 🔥 Why Annotation?

Purane time me har servlet ke liye web.xml me 8–10 line likho… boring & time waste 🥱
Ab:

- ✔ Faster development
- ✔ No XML headache
- ✔ Readability ↑
- ✔ Less files, less config
- ✔ Code aur configuration saath-saath 😍

### ⚙️ Servlet 3.0 + Annotation — @WebServlet

Example 👇
```java
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
```

### 🧠 What did we just do?

Feature	XML Era	Annotation Era
Mapping	web.xml required	Only @WebServlet
Config visibility	Different file	Same class → easy
Project size	More files	Reduced
Speed	Slow setup	Fast & clean
💪 Useful Options in @WebServlet

### You can use multiple URL routes:
```java
@WebServlet(urlPatterns = {"/one", "/two"})
```

### Load servlet at startup:
```java
@WebServlet(urlPatterns="/test", loadOnStartup=1)
```

### Init params:
```java
@WebServlet(
    urlPatterns="/db",
    initParams = {
        @WebInitParam(name="user", value="root"),
        @WebInitParam(name="pass", value="1234")
    }
)
```

> 🧠 Ab servlet ke constructor jaisa config mil gaya → web.xml ki jarurat nahi!

### 🔥 Short Interview Pointers

Question	Solid Answer
Servlet mapping kahan hota hai?	@WebServlet annotation or web.xml
Servlet 3.0 introduced what?	Annotation-based config + Pluggability
What is Pluggability?	Servlets without web.xml

----

## 🚦 HTTP Servlet Request & Response

Web ka communication request-response model pe chalta hai:

Client bheje Request → Server bheje Response
Yeh cycle chalta hi rehta hai 🔁 😎

### 1️⃣ HttpServletRequest → Client ki taraf se jo aata hai 🌐➡️🛠️

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

### 2️⃣ HttpServletResponse → Server ki taraf se jo jata hai 🛠️➡️🌐

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

### 🧠 Example — Combining Both

Form se naam bheja & response me show kiya:
```java
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    
    resp.setContentType("text/html");

    String name = req.getParameter("username");

    PrintWriter out = resp.getWriter();
    out.println("<h2>Welcome " + name + " 💫</h2>");
}
```

### 🎯 Interview Style Points
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

---
> “Request aati hai tab duniya chalti hai, Response jaata hai tab result dikhta hai!” 😎🔥   
---

## 1️⃣ HTTP GET vs POST – Antar
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

---
## 2️⃣ doGet() vs doPost() – Internals
```java
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
```

### Internals:

service() method decide karta hai ki GET → doGet(), POST → doPost()

doGet() = Mostly read operations

doPost() = Mostly write operations

---
## 3️⃣ Form Handling – GET & POST Example
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

---

## 4️⃣ Query Params vs Body Params
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

---
## 5️⃣ Redirect vs Forward (Servlet World)
Feature	Redirect	Forward
Browser URL	Change ho jata	Same rahta
Client request	Naya request karta	Same request pass
Server load	Extra request → thoda zyada	Efficient, server side hi handle
Use Case	Login success → dashboard	Servlet to JSP data pass

---
Example Servlet Redirect
response.sendRedirect("dashboard.jsp");

Example Servlet Forward
RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
rd.forward(request, response);
