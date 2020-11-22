# 1 Servlet Programming

## 1.1 Components

### 1.1.1 Java EE Components

- Application clients and applets
- Java Servlet, JavaServer Pages(JSP) and JavaServer Faces(JSF)
- EJB components(enterprise beans)

### 1.1.2 Java EE clients
- Web clients
- Application clients
- Applets

### 1.1.3 Java EE Containers

- Containers: interface between a component and the low-level, platform-specific functionality that supports the component
- Container Types
  - The deployment process installs Java EE application components in the containers

### 1.1.4 Java Web Container and Application Servers

- Java web container
  - Apache Tomcat
  - Jetty
  - ...
- Java EE application server
  - GlassFish
  - Jboss
  - WebLogic
  - WebSphere
  - ...

### 1.1.5 Web Applications
- Servlets, JSP/JSF, web service endpoints
- Supported by web containers

## 1.2 Servlet
- A servlet is a small Java program that runs whitin a web server
- receive and respond to requests from web clients, usually across HTTP
- The web container will hava one or more built-in servlets
- Servlet implements javax.servlet.Servlet

### 1.2.1 Implementing a Simple Servlet
- Create a servlet cclass
- Configure servlet and URL mapping
  - deployment descriptor
- Override servlet methods to perform actions
- Deploy and run the servlet

### 1.2.2 Processing Request and Response
- HttpServletRequest
- HttpServletResponse

### 1.2.3 Forwarding and Redirection
- The `RequestDispatcher` object
- The `sendRedirect()` method

### 1.2.4 Persisting Application Data
- Store and retrieve object in/from a request
- Attach objects to the servlet contextt

### 1.2.5 Servlet Lifecycle
- Controlled by the container
- Whenever a request is mapped to a servlet
  - If no instance exists
    - Load the class
    - Create an instance
    - Initialize the servlet instance
  - Invoke the service method
- Using the Initializer and Destroyer 

### 1.2.6 Servlet Configuration for Deployment

- Servlet initialization
  - Load on startup
  - Context init parameters
  - Servlet init parameters