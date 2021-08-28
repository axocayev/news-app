package az.atlacademy.news.util;

import az.atlacademy.news.entity.Author;
import az.atlacademy.news.repository.AuthorRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class MathCalculationTest {

    MathCalculation mathCalculation;


    @BeforeEach
    void setUp() {
        mathCalculation = new MathCalculation();
    }

    @Test
    @Order(4)
    @DisplayName("Sum calcualtion")
    void testSumCalculation() {
        assertEquals(10, mathCalculation.calc(7, 3, '+'), "Sum calculation copmleted");
        assertEquals(4, mathCalculation.calc(7, 3, '-'), "Sum calculation copmleted");
        assertEquals(24, mathCalculation.calc(8, 3, '*'), "Sum calculation copmleted");
        assertEquals(2, mathCalculation.calc(10, 5, '/'), "Sum calculation copmleted");

    }

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testSaveAuthorSuccess(){
        Author author=new Author();
        author.setSurname("Aliyev");
        author.setName("Nihad");
        assertNotNull(authorRepository);
       // assertNotNull(authorRepository.save(author));
    }


/*    @Test
    @DisplayName("Sum calcualtion excetpion")
    void testSumCalculationException(){

        Throwable throwable=assertThrows(ArithmeticException.class,
                ()->mathCalculation.calc(10,0,'/') );

          assertEquals("/ by zero",throwable.getMessage());

    }*/


    @Test
    @Order(2)
    @DisplayName("Sum calcualtion excetpion")
    void testSumCalculationException() {

        assertEquals(0, mathCalculation.calc(10, 0, '/'));

    }

    @Test
    @Order(3)
    @DisplayName("Convert")
    void testConvert() {
        assertNotNull(mathCalculation.convert(73), "Convert completed");
    }

    @Test
    @Order(1)
    @DisplayName("Assert all test")
    void testAddress() {
        Address address = new Address();
        address.setFirstName("anar");
        address.setLastName("xocayev");
        assertAll("address",
                () -> assertEquals("anar", address.getFirstName()),
                () -> assertEquals("xocayev", address.getLastName())
        );

    }


}
