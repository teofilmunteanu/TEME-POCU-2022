import java.util.Comparator;

public class StudentComparator implements Comparator<StudentImproved> {
    @Override
    public int compare(StudentImproved s1, StudentImproved s2) {
        if (s1.name.compareTo(s2.name) == 0)
            return 0;
        else if (s1.name.compareTo(s2.name) > 0)
            return 1;
        else
            return -1;
    }
}
