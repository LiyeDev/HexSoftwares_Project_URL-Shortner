 package com.example.urlshortener.controller;

   import com.example.urlshortener.service.UrlService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.http.HttpStatus;
   import org.springframework.http.ResponseEntity;
   import org.springframework.web.bind.annotation.*;

   @RestController
   @RequestMapping("/url")
   public class UrlController {

       @Autowired
       private UrlService urlService;

       @PostMapping("/shorten")
       public ResponseEntity<String> shortenUrl(@RequestBody String originalUrl) {
           return new ResponseEntity<>(urlService.shortenUrl(originalUrl), HttpStatus.CREATED);
       }

       @GetMapping("/{shortUrl}")
       public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
           String originalUrl = urlService.getOriginalUrl("http://localhost:8080/" + shortUrl);
           if (originalUrl == null) {
               return ResponseEntity.notFound().build();
           }
           return ResponseEntity.status(HttpStatus.FOUND)
                   .location(URI.create(originalUrl))
                   .build();
       }
   }
