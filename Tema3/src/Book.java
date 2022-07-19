import java.util.List;

public class Book extends Media{
    String author;
    String content;

    public Book(String title, String _author, String _content){
        super(title);
        author = _author;
        content = _content;
    }
}
