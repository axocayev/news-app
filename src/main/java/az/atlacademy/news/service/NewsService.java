package az.atlacademy.news.service;

import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.repository.AuthorRepository;
import az.atlacademy.news.repository.NewsRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsService {
   private NewsRepository newsRepository;
   private AuthorRepository authorRepository;

    public NewsService(NewsRepository newsRepository, AuthorRepository authorRepository) {
        this.newsRepository = newsRepository;
        this.authorRepository = authorRepository;
    }

    public News createNews(NewsPayload newsPayload){
        System.out.println("Srevice "+newsPayload);
        News news=new News();
        news.setActive(true);
        news.setDeleted(false);
        news.setTitle(newsPayload.getTitle());
        news.setContent(newsPayload.getContent());
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdateAt(LocalDateTime.now());
        news.setAuthor(authorRepository.findById(newsPayload.getAuthorId()).get());

        System.out.println("Srevice "+news);


        return newsRepository.save(news);
    }

    public News updateNews(NewsPayload newsPayload) {

        System.out.println("Srevice "+newsPayload);

        News news=new News();
        news.setId(newsPayload.getId());
        news.setActive(true);
        news.setDeleted(false);
        news.setTitle(newsPayload.getTitle());
        news.setContent(newsPayload.getContent());
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdateAt(LocalDateTime.now());

        System.out.println("Srevice "+news);


        return newsRepository.save(news);
    }

    public List<News> getAll(){
        return newsRepository.findAll();
    }

    public News getNewsById(Long newsId){
        return newsRepository.findByIdAndIsActiveIsTrueAndIsDeletedIsFalse(newsId).orElseThrow(()->new RuntimeException("Not found "));
    }
}
