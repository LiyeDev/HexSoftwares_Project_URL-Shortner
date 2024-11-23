### Prerequisites
1. Java Development Kit (JDK)
2. Maven (for managing dependencies)
3. Spring Boot dependencies


These are the steps to creating a URL Shoteneing Service:
  1. Setup a spring boot Project
  2. Create a Project Structure
  3. Use Maven "pom.xml"
  4. Create a URL Shortener Application
  5. Create the URL Service
  6. Create the Controller


To Run the Application:
   Run your application using "mvn spring-boot:run" in your terminal. Once the application    is running, you can interact with it.

Testing the Service
  To Shorten the URL:
   You can use tools like "curl" or Postman to send a POST request to     "http://localhost:8080/url/shorten" with the original URL in the body.

On bash use the following prompt;
   ``
   curl -X POST http://localhost:8080/url/shorten -d "https://www.example.com"
   ``



To Redirect:
   You can test the shortened URL by hitting the endpoint you receive in response:
   
   ``` on bash
   curl http://localhost:8080/{shortened-url-id}  
# Replace with actual shortened URL
   ```



Conclusion
  This simple URL shortening service uses an in-memory map to store URL mappings. In a       production scenario, you would likely want to use a database to persist the URL mappings   and enhance other features like handling duplicate URLs, custom URL slugs, analytics,      etc.
