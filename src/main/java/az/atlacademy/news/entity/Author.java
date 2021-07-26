package az.atlacademy.news.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data

@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author",fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private Set<News> news;


}
