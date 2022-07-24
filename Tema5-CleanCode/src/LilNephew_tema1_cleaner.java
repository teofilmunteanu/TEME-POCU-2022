//Refactorized - cleaner code
public class LilNephew_tema1_cleaner extends Person_tema1_cleaner implements Annoyable{
    private int hungerDecrease = 20;

    public LilNephew_tema1_cleaner(String name){
        super(name);
    }

    @Override
    public void beAnnoying() {
        System.out.println("Lil nephew " + getName() + " :");
        throwObjectsAround();
        yell();
    }

    @Override
    public void eat(){
        System.out.println(getName() + ": I don't like thiiiis!!");

        setHunger(getHunger()-hungerDecrease);
    }

    public void throwObjectsAround(){
        System.out.println("*throws object at someone*");
    }

    public void yell(){
        System.out.println("waaaa!");
    }
}
