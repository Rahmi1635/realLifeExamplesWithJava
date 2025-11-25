import java.time.LocalDate;


public class News {

    private static int counterId=0;

    private String title;
    private String content;
    private String author;
    private String category;
    private LocalDate timeStamp;
    private int id;

    public News(String title,String content,String author,String category,LocalDate timeStamp)
    {
        this.id=counterId++;
        this.title=title;
        this.content=content;
        this.author=author;
        this.category=category;
        this.timeStamp=timeStamp;
    }

    public int getId() {
        return id;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

}
