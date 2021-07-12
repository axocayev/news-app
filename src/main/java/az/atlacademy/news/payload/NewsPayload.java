package az.atlacademy.news.payload;

public class NewsPayload {
    private Long id;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewsPayload{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
