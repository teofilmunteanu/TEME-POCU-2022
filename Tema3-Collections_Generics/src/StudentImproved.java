import java.util.Objects;

public class StudentImproved {
    String name;
    String personalCode;

    public StudentImproved(String _name, String _personalCode) {
        name = _name;
        personalCode = _personalCode;
    }

    public String getName() {
        return name;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    @Override
    public boolean equals(Object obj){
        StudentImproved student2 = (StudentImproved) obj;
        return name.equals(student2.name) && personalCode.equals(student2.personalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, personalCode);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Code: " + personalCode + '\n';
    }
}

