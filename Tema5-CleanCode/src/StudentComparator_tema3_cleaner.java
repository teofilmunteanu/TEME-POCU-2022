//Refactorized - cleaner code
import java.util.Comparator;

public class StudentComparator_tema3_cleaner implements Comparator<StudentImproved> {
    @Override
    public int compare(StudentImproved s1, StudentImproved s2) {
        if (s1.name.compareTo(s2.name) == 0)
            return 0;

        return s1.name.compareTo(s2.name) > 0 ? 1 : -1;
    }
}
