package az.atlacademy.news.controller;

import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/news")
public class NewsController {

    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    ResponseEntity<News>  createNews(@RequestBody NewsPayload newsPayload){
        System.out.println("Controller " + newsPayload);
     return new  ResponseEntity<>(newsService. createNews(newsPayload), HttpStatus.CREATED)   ;
    }

    @PutMapping
    ResponseEntity<News>  updateNews(@RequestBody NewsPayload newsPayload){
        System.out.println("Controller " + newsPayload);
        return new  ResponseEntity<>(newsService. updateNews(newsPayload), HttpStatus.OK)   ;
    }


}
