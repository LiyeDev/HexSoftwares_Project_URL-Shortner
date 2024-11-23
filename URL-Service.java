package com.example.urlshortener.service;

   import java.util.HashMap;
   import java.util.Map;
   import java.util.concurrent.atomic.AtomicInteger;
   import org.springframework.stereotype.Service;

   @Service
   public class UrlService {
       private final Map<String, String> urlMap = new HashMap<>();
       private final AtomicInteger idCounter = new AtomicInteger(1);
       private static final String BASE_URL = "http://localhost:8080/";

       public String shortenUrl(String originalUrl) {
           String shortUrl = BASE_URL + idCounter.getAndIncrement();
           urlMap.put(shortUrl, originalUrl);
           return shortUrl;
       }

       public String getOriginalUrl(String shortUrl) {
           return urlMap.get(shortUrl);
       }
   }
