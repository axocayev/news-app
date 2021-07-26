package az.atlacademy.news.payload;


import lombok.Data;

@Data
public class NewsPayload {
    private Long id;
    private String title;
    private String content;
    private Long authorId;

}
