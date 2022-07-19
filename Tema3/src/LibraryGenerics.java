import java.util.ArrayList;
import java.util.List;

public class LibraryGenerics<T> {
    private List<T> resources = new ArrayList<>();

    public void addMedia(T element) {
        resources.add(element);
    }

    public T retrieveLast() {
        return resources.get(resources.size()-1);
    }

    public T retrieveFirst() {
        return resources.get(0);
    }
}
