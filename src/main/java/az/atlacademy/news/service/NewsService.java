package az.atlacademy.news.service;

import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NewsService {
   private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
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
}
