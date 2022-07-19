/*Inheritance: class Mosquito inherits the non-private methods and attributes of class Insect */
/*Abstraction: must implement the methods listed in the Annoyable interface and the Insect abstract class by overriding them*/
public class Housefly extends Insect implements Annoyable{
    /*Polymorphism/Abstraction: Overriding the "beAnnoying" method, as required by the implementation of Annoyable*/
    @Override
    public void beAnnoying() {
        System.out.println("Fly:");
        makeNoise();
        flyOnFood();
    }

    /*Polymorphism/Abstraction: Overriding the "makeNoise" abstract method, as required by inheriting Insect*/
    @Override
    public void makeNoise(){
        System.out.println("Bz bz bz");
    }

    public void flyOnFood(){
        System.out.println("*lands on food*");
    }
}
