package az.atlacademy.news.service;

import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.repository.AuthorRepository;
import az.atlacademy.news.repository.NewsRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewsService {
   private final NewsRepository newsRepository;
   private final AuthorRepository authorRepository;



    public News createNews(NewsPayload newsPayload){
       log.info("Service {}", newsPayload);
        News news=new News();
        news.isActive(true);
        news.isDeleted(false);
        news.setTitle(newsPayload.getTitle());
        news.setContent(newsPayload.getContent());
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdateAt(LocalDateTime.now());
        news.setAuthor(authorRepository.findById(newsPayload.getAuthorId()).get());

        log.info("Service {}", news);


        return newsRepository.save(news);
    }

    public News updateNews(NewsPayload newsPayload) {

        log.info("Service {}", newsPayload);

        News news=new News();
        news.setId(newsPayload.getId());
        news.isActive(true);
        news.isDeleted(false);
        news.setTitle(newsPayload.getTitle());
        news.setContent(newsPayload.getContent());
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdateAt(LocalDateTime.now());


        log.info("Service {}", news);


        return newsRepository.save(news);
    }

    public List<News> getAll(){
        return newsRepository.findAll();
    }

    public News getNewsById(Long newsId){
        return newsRepository.findByIdAndIsActiveIsTrueAndIsDeletedIsFalse(newsId).orElseThrow(()->new RuntimeException("Not found "));
    }
}
