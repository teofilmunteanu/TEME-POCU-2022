public class MyException2 extends Exception{
    public MyException2(String errorMessage){
        super("Second exception " + errorMessage);
    }
}
