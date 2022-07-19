import java.util.ArrayList;
import java.util.List;

public class LibraryNoGenerics {
    private List<Media> resources = new ArrayList<>();

    public void addMedia(Media element) {
        resources.add(element);
    }

    public Media retrieveLast() {
        return resources.get(resources.size()-1);
    }

    public Media retrieveFirst() {
        return resources.get(0);
    }
}
