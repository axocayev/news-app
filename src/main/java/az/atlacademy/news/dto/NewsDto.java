package az.atlacademy.news.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class NewsDto {
    private Long id;
    private String newsTitle;
    private String content;
    @JsonIgnore
    private Long visitCount;
    private String author;
}
