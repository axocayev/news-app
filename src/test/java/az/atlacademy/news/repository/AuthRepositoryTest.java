package az.atlacademy.news.repository;


import az.atlacademy.news.entity.Author;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthRepositoryTest {


    @Mock
    AuthorRepository  authorRepository;

    final static Author author=new Author();
    final static Author authorSaved=new Author();
    final static Optional<Author> authorSaved2= Optional.of(new Author());
    @BeforeEach
    void setUp(){
        author.setName("Kamil");
        author.setSurname("Aliyev");

        authorSaved.setName("Kamil");
        authorSaved.setSurname("Aliyev");

        authorSaved2.get().setName("Ali");
        authorSaved2.get().setSurname("Aliyev");
    }


    @Test
    @DisplayName("checl repo is cretated ")
    void testAuthorRepoNotNull(){
        assertNotNull(authorRepository);
    }

    @Test
    @DisplayName("checl repo is cretated ")
    void testSaveAuthorRepoSuccess(){
        //before
        when(authorRepository.save(author)).thenReturn(authorSaved);

        //after
        authorRepository.save(author);


       //assert
        assertEquals(author.getName(),authorSaved.getName());
        assertEquals(author.getSurname(),authorSaved.getSurname());
    }

    @Test
    @DisplayName("checl repo is cretated ")
    void testFindIdAuthorSuccess(){
        //before
        when(authorRepository.findById(15L)).thenReturn(authorSaved2);

        //after
        authorRepository.findById(15L).get();


        //assert
        assertNotNull(authorSaved2);
        assertEquals(authorSaved2.get().getSurname(),"Aliyev");
        assertEquals(authorSaved2.get().getName(),"Ali");
    }
}
