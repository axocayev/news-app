package az.atlacademy.news.service;

import az.atlacademy.news.dto.NewsDto;
import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;

import java.util.List;


public interface NewsService {

     News createNews(NewsPayload newsPayload);
     News updateNews(NewsPayload newsPayload) ;
     List<News> getAll() ;
     News getNewsById(Long newsId) ;
     NewsDto getNewsByIdMapper(Long newsId);
}
