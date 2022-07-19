import java.util.List;
import java.util.Scanner;

public class DiningRoom {
    public List<Person> diningPeople;
    public List<Annoyable> pests;

    public DiningRoom(List<Person> _diningPeople, List<Annoyable> _pests){
        diningPeople = _diningPeople;
        pests = _pests;
        readPeopleHunger();
    }

    private void readPeopleHunger(){
        Scanner sc = new Scanner(System.in);

        for(Person person : diningPeople){
            System.out.print(person.getName() + ":");
            person.setHunger(sc.nextInt());
            System.out.println(person.getName() + "'s hunger is " + person.getHunger());
        }
    }

    public void serveDinner(){
        System.out.println("\nDinner is served!\n");

        for(Person person : diningPeople){
            if(person.getHunger() > 0){
                person.eat();
            }
        }

        for(Annoyable pest : pests){
            System.out.println();
            pest.beAnnoying();
        }
    }
}
