package az.atlacademy.news.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


///POJO
@Data
@ToString(exclude = {"author","isDeleted"})
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long visitCount;
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name="author_id",nullable = false)
    private Author author;
    @Accessors(fluent = true)
    private Boolean isActive;
    @Accessors(fluent = true)
    private Boolean isDeleted;

}
/*
class Test{
    public static void main(String[] args) {
        News news=new News();
        news.setAuthor(new Author().builder().id(1L).name("Anar").surname("Xocayev").build());
        news.setTitle("Title");//1871617447,  -1147234944, -1147195552
        news.setContent("Content");
        news.isDeleted(true);
        news.isActive(true);

        News news1=new News();
        news1.setAuthor(new Author());
        news1.setTitle("Title");//1871617447,  -1147234944, -1147195552
        news1.setContent("Content");
        news1.isDeleted(true);
        news1.isActive(true);

        System.out.println(news.hashCode());
        System.out.println(news1.hashCode());

        Set<News> newsSet=new HashSet<>();
        newsSet.add(news);
        newsSet.add(news1);
        System.out.println(news.equals(news1));

        System.out.println(newsSet.size());

    }
}

*/
