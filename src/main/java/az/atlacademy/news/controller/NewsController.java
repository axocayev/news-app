package az.atlacademy.news.controller;

import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/news")

public class NewsController {

    private final NewsService newsService;

    @PostMapping
    ResponseEntity<News>  createNews(@RequestBody NewsPayload newsPayload){
        System.out.println("Controller " + newsPayload);
     return new  ResponseEntity<>(newsService. createNews(newsPayload), HttpStatus.CREATED)   ;
    }

    @PutMapping
    ResponseEntity<News>  updateNews(@RequestBody NewsPayload newsPayload){
        System.out.println("Controller " + newsPayload);
        return new  ResponseEntity<>(newsService.updateNews(newsPayload), HttpStatus.OK)   ;
    }
    @GetMapping
    ResponseEntity<List<News>>  getAll(){
        System.out.println("Controller " );
        return new  ResponseEntity<>(newsService.getAll(), HttpStatus.OK)   ;
    }
    @GetMapping("/{newsId}")
    ResponseEntity<News>  getAll(@PathVariable("newsId") Long newsId ){
        System.out.println("Controller " );
        return new  ResponseEntity<>(newsService.getNewsById(newsId), HttpStatus.OK)   ;
    }

}
