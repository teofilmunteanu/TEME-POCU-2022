import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Dave");
        Person person2 = new Person("Steve");
        Person person3 = new Person("Jim", "Much appreciated meal!");

        LilNephew nephew = new LilNephew("Jimmy");

        Telemarketer telemarketer1 = new Telemarketer("Karen");
        Mosquito mosquito1 = new Mosquito();
        Housefly fly1 = new Housefly();


        List<Person> persons = Arrays.asList(person1, person2, person3, nephew);
        List<Annoyable> pests = Arrays.asList(telemarketer1, mosquito1, fly1, nephew);

        System.out.println("Enter the hunger levels(0-100):");
        DiningRoom room = new DiningRoom(persons, pests);
        room.serveDinner();
    }
}