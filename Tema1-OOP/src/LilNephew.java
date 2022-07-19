/*Inheritance: class LilNephew inherits the non-private methods and attributes of class Person */
/*Abstraction: must implement the methods listed in the Annoyable interface by overriding them*/
public class LilNephew extends Person implements Annoyable{
    public LilNephew(String name){
        super(name);
    }

    /*Polymorphism/Abstraction: Overriding the "beAnnoying" method, as required by the implementation of Annoyable*/
    @Override
    public void beAnnoying() {
        System.out.println("Lil nephew " + getName() + " :");
        throwObjectsAround();
        yell();
    }

    /*Polymorphism: Overriding the inherited behaviour of "eat"(modifies the initial behaviour of the parent class Person)*/
    @Override
    public void eat(){
        System.out.println(getName() + ": I don't like thiiiis!!");

        setHunger(getHunger()-20);
    }

    public void throwObjectsAround(){
        System.out.println("*throws object at someone*");
    }

    public void yell(){
        System.out.println("waaaa!");
    }
}
