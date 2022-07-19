public class Student {
    String name;
    String personalCode;

    public Student(String _name, String _personalCode) {
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
    public String toString() {
        return "Name: " + name + ", Code: " + personalCode + '\n';
    }
}
