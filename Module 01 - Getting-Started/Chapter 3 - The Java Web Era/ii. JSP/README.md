# Java Server Page 🎬

Before understanding jsp let first understood why we need jsp ?
thus we have to carry out first limitation of java servlet ...
as in servlet a request goes to server , than the server will process it and generate a response . later this response we show on browser using - 
 ```Out.print(<h1>response</h1>)```
this is actually reason behind **JSP** Existance . this way of generatic dynamic response and showing dynamic pages using **HTML** looking messy and confusing.
> there is no separation between Frontend code and Backend Logic .

## Solution is Jsp - 
Thus Jsp is introduced and provide a Option to differentiate Logic and presentation . hence we used **Servelet** in backend and use **JSP** for presentation 
**jsp is a Html page allowing programmer to write java code to build logics.**
**whereas , servlet is a java class which used PrintWriter.getWriter().print() - to Write Dynamic content in html .**

---

## Jsp LifeCycle -
jsp having 6 phases -
- **1. Translation**
JSP coverts into Servlet 
- **2. Compilation**
  Servlet class compile into .class
- **3. Load $ Instantiation**
  classLoader load the class and an object of servlet class creates
- **4. Initialization**
  call jspInit() same as Init() of servlet
- **5. Request Handling**
  call jspService() same as Service() of servlet
- **6. Destroy();**
  Similar to Destroy() of servlet . but here it calls - jspDestroy()
---

## Tags in Jsp -
there are 3 Types of Tags
- **1. Scrpiting Tag**
  These tag basically used to add java code inside jsp . they are further divide into three -

| Tag             | Syntax         | Purpose                          |
| --------------- | -------------- | -------------------------------- |
| **Scriptlet**   | `<% code %>`   | Java logic (if/else, loop, etc.) |
| **Expression**  | `<%= value %>` | Output print directly            |
| **Declaration** | `<%! code %>`  | Variables/methods declaration    |

Example-
```
<%! int count = 0; %>
<%
    count++;
%>
<p>Visit Count: <%= count %></p>

```

- **2. Directive Tag**
  Controls Behaviour and Configurations
  
| Directive   | Syntax                   | Purpose                    |
| ----------- | ------------------------ | -------------------------- |
| **page**    | `<%@ page ... %>`        | Import, error, buffer etc. |
| **include** | `<%@ include file="" %>` | Static include of JSP/HTML |
| **taglib**  | `<%@ taglib ... %>`      | Custom tag support (JSTL)  |

Example -
```
<%@ page import="java.util.*" %>

``` 
- **3. Associative Tag**
  for Servlet/JSP communication
  
| Action              | Syntax            | Purpose |
| ------------------- | ----------------- | ------- |
| `<jsp:useBean>`     | Bean create       |         |
| `<jsp:setProperty>` | Bean property set |         |
| `<jsp:getProperty>` | Bean property get |         |
| `<jsp:include>`     | Dynamic include   |         |
| `<jsp:forward>`     | Request forward   |         |

Example -
```
<jsp:include page="header.jsp"/>
```
---
## JSP Implicit Objects
JSP provides 9 implicit objects that can be used directly without declaring or importing them.
They help in interacting with various parts of a web application such as request, response, session, etc.

| Object          | Type                  | Description                                                   |
| --------------- | --------------------- | ------------------------------------------------------------- |
| **request**     | `HttpServletRequest`  | Access form data, request headers, parameters, etc.           |
| **response**    | `HttpServletResponse` | Modify and send response to the client (redirect, headers...) |
| **session**     | `HttpSession`         | Store and track user session-level data                       |
| **application** | `ServletContext`      | Share data across the entire application                      |
| **out**         | `JspWriter`           | Write output to the browser                                   |
| **config**      | `ServletConfig`       | Servlet-specific initialization configuration                 |
| **pageContext** | `PageContext`         | Provides access to all implicit objects and JSP environment   |
| **page**        | `Object`              | Reference to the current JSP page instance                    |
| **exception**   | `Throwable`           | Available only in error pages to handle exceptions            |

📌 Example Usage
```
Username: <%= request.getParameter("name") %>
Session Email: <%= session.getAttribute("email") %>
Application Param: <%= application.getInitParameter("db_url") %>

```
## Expression Language (EL)
JSP Expression Language allows simple and clean access to data stored in different scopes.
It replaces Java scriptlet code from JSP for better readability and maintainability.
Syntax
```
${variable}
${object.property}
```
Example:
```
<p>Name: ${param.name}</p>
<p>Session User: ${sessionScope.username}</p>
<p>Count + 10 = ${count + 10}</p>
```
