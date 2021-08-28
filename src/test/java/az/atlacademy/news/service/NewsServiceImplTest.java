package az.atlacademy.news.service;

//https://www.vogella.com/tutorials/Mockito/article.html


import az.atlacademy.news.entity.Author;
import az.atlacademy.news.entity.News;
import az.atlacademy.news.payload.NewsPayload;
import az.atlacademy.news.repository.AuthorRepository;
import az.atlacademy.news.repository.NewsRepository;
import az.atlacademy.news.service.impl.NewsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsServiceImplTest {
    @Mock
    private  NewsRepository newsRepository;

    @Mock
    private  AuthorRepository authorRepository;

    @InjectMocks
    NewsServiceImpl newsService;

    static NewsPayload newsPayload=new NewsPayload();
    final static Optional<Author> authorSaved2= Optional.of(new Author());
    static  News news =new News();
    final static Optional<News> newsOp= Optional.of(new News());

    static List<News> newsList=new ArrayList<>();
    @BeforeEach
    void setUp(){
        newsPayload.setContent("Content");
        newsPayload.setAuthorId(12L);
        newsPayload.setTitle("Title");

        authorSaved2.get().setName("Ali");
        authorSaved2.get().setSurname("Aliyev");


        newsOp.get().setTitle("Title");
        newsOp.get().setContent("Content");

        news.setTitle("Title");
        news.setContent("Content");
        newsList.add(news);

    }


    @Test
    @DisplayName("test mock objects ")
    void testObjectsNotNull(){
        assertNotNull(authorRepository);
        assertNotNull(newsRepository);
        assertNotNull(newsService);
    }

    @Test
    @DisplayName("Create news")
    void testCreateNewsSuccess(){
        //arrange
        when(authorRepository.findById(12L)).thenReturn(authorSaved2);
        when(newsRepository.save(any())).thenReturn(news);

        //act
        News newsSaved = newsService.createNews(newsPayload);

        //assert
        assertNotNull(newsSaved);
        assertNotNull(newsSaved.getContent());
        assertEquals(newsSaved.getTitle(),news.getTitle());
        assertEquals(newsSaved.getContent(),news.getContent());


    }


    @Test
    @DisplayName("Update news")
    void testUpdateNewsSuccess(){
        //arrange

        when(newsRepository.save(any())).thenReturn(news);

        //act
        News newsSaved = newsService.updateNews(newsPayload);

        //assert
        assertNotNull(newsSaved);
        assertNotNull(newsSaved.getContent());
        assertEquals(newsSaved.getTitle(),news.getTitle());
        assertEquals(newsSaved.getContent(),news.getContent());


    }


    @Test
    @DisplayName("Update news")
    void testFindAllNewsSuccess(){
        //arrange

        when(newsRepository.findAll()).thenReturn(newsList);

        //act
        List<News> newsList1 = newsService.getAll();

        //assert
        assertNotNull(newsList1);
        assertFalse(newsList1.isEmpty());
        assertEquals(newsList1.size(),1);
        assertEquals(newsList1.get(0).getTitle(),"Title");
        assertEquals(newsList1.get(0).getContent(),"Content");


    }

    @Test
    @DisplayName("find by id - news")
    void testFindByIdNewsSuccess(){
        //arrange

        when(newsRepository.findByIdAndIsActiveIsTrueAndIsDeletedIsFalse(12L)).thenReturn(newsOp);

        //act
        News news1 = newsService.getNewsById(12L);

        //assert
        assertNotNull(news1);
        assertNotNull(news1.getContent());
        assertEquals(news1.getTitle(),news.getTitle());
        assertEquals(news1.getContent(),news.getContent());


    }




}
