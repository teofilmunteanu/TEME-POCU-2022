public class Person {
    private String name;
    private int hunger;
    protected String dinnerMessage;

    /*Polymorphism - Overloading: methods with the same name but different parameter lists, called in accordance with the number of parameters given*/
    public Person(String _name){
        name = _name;
        dinnerMessage = "Thank you for the meal!";
    }


    public Person(String _name, String message){
        name = _name;
        dinnerMessage = message;
    }
    /*-------------------------------------------------*/

    /*Encapsulation: the data is protected from free outside access or invalid modifications*/
    /*Ex1: The name should only be received, and never changed*/
    public String getName(){
        return name;
    }

    /*Ex2: The hunger should always be in range 0-100 */
    public void setHunger(int hungerLevel){
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
    }

    public int getHunger() { return hunger; }

    public void eat(){
        System.out.println(name + ": " + dinnerMessage);
        hunger = 0;
    }
}
