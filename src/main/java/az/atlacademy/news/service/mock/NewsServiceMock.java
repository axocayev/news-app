package az.atlacademy.news.service.mock;

import az.atlacademy.news.dto.NewsDto;
import az.atlacademy.news.entity.Author;
import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.service.NewsService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Profile("integration")
public class NewsServiceMock implements NewsService {
    @Override
    public News createNews(NewsPayload newsPayload) {
        return null;
    }

    @Override
    public News updateNews(NewsPayload newsPayload) {
        return null;
    }

    @Override
    public List<News> getAll() {
        return null;
    }

    @Override
    public News getNewsById(Long newsId) {
        News news =new News();
        news.setId(newsId);
        news.setContent("news content");
        news.setTitle("news title");
        Author author=new Author();
        author.setId(1L);
        author.setName("Anar");
        author.setSurname("Xocayev");
        news.setAuthor(author);
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdateAt(LocalDateTime.now());
        news.setVisitCount(12L);

        return news;
    }

    @Override
    public NewsDto getNewsByIdMapper(Long newsId) {

        return new NewsDto();
    }
}
