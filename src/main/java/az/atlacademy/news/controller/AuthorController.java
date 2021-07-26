package az.atlacademy.news.controller;

import az.atlacademy.news.entity.Author;
import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.AuthoPayload;
import az.atlacademy.news.payload.NewsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {
    @PostMapping
    ResponseEntity<Author> createAuthor(@RequestBody AuthoPayload authoPayload){

        return null   ;
    }
}
