package az.atlacademy.news.controller;

import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.service.NewsService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/news")
@Api(produces = MediaType.APPLICATION_JSON_VALUE,tags = " News CRUD operations ")
public class NewsController {

    private final NewsService newsService;

    @PostMapping
    @ApiOperation(value="This method create NEWS",response = News.class ,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiResponses(value={
            @ApiResponse(code=200 ,message = "News was successfuly created"),
            @ApiResponse(code=500 ,message = "Internal server error ocured")

    })
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
        return new  ResponseEntity<>(newsService.getAll(), HttpStatus.OK)   ;
    }
    @GetMapping("/{newsId}")
    ResponseEntity<News>  getAll(
            @ApiParam(value = "news id" ,name = "newsId",example = "12")
            @PathVariable("newsId") Long newsId ){

        return new  ResponseEntity<>(newsService.getNewsById(newsId), HttpStatus.OK)   ;
    }

}
