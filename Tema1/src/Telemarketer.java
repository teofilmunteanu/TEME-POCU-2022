import java.util.List;
import java.util.Random;
import java.util.Arrays;

/*Inheritance: class Telemarketer inherits the non-private methods and attributes of class Person */
/*Abstraction: must implement the methods listed in the Annoyable interface by overriding them*/
public class Telemarketer extends Person implements Annoyable{
    public List<String> itemsToSell;

    public Telemarketer(String name){
        /*Call parent's(Person's) constructor to assign the "name" attribute, as required by its constructor*/
        super(name);
        itemsToSell = Arrays.asList("super vacuum", "nonstick skillet", "back massager");
    }

    /*Overriding the "beAnnoying" method, as required by the implementation of Annoyable*/
    @Override
    public void beAnnoying() {
        System.out.println("Telemarketer:");
        String item = getRandomUselessItem();
        advertiseItem(item);
        bePersistentAboutItem(item);
    }

    public void advertiseItem(String item){
        System.out.println("Hello, my name is " + this.getName() + ".");
        System.out.println("Would you interested in buying a " + item + "?");
    }

    public void bePersistentAboutItem(String item){
        System.out.println("But, our " + item + " is very useful!");
        System.out.println("If you buy it now, you get a 15% off.");
    }

    private String getRandomUselessItem(){
        Random rand = new Random();
        return itemsToSell.get(rand.nextInt(itemsToSell.size()));
    }
}
