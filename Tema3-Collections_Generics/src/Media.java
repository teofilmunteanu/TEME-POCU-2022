public class Media {
    private String title;

    public Media(String _title) {
        title = _title;
    }

    @Override
    public String toString() {
        return "Title: " + title;
    }
}
