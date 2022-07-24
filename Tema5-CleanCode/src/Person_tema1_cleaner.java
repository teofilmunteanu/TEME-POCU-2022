//Refactorized - cleaner code
public class Person_tema1_cleaner {
    private String name;
    private int hunger;
    private final int minHunger = 0, maxhunger = 100;

    protected String dinnerMessage;

    public Person_tema1_cleaner(String _name){
        name = _name;
        dinnerMessage = "Thank you for the meal!";
    }

    public Person_tema1_cleaner(String _name, String message){
        name = _name;
        dinnerMessage = message;
    }

    public String getName(){
        return name;
    }

    public void setHunger(int hungerLevel){
        /* OLD
        if(hungerLevel < 0){
            hunger = 0;
            return;
        }
        if(hungerLevel > 100){
            hunger = 100;
            return;
        }
        if(hungerLevel >= 0 && hungerLevel <= 100){
            hunger = hungerLevel;
        }
        */

        if(hungerLevel < minHunger){
            hunger = minHunger;
            return;
        }
        if(hungerLevel > maxhunger){
            hunger = maxhunger;
            return;
        }

        hunger = hungerLevel;
    }

    public int getHunger() { return hunger; }

    public void eat(){
        System.out.println(name + ": " + dinnerMessage);
        hunger = 0;
    }
}
