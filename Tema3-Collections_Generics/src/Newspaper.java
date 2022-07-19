public class Newspaper extends Media{
    String date;
    String content;

    public Newspaper(String title, String _date, String _content){
        super(title);
        date = _date;
        content = _content;
    }
}
