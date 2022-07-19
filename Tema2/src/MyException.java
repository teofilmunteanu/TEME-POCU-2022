public class MyException extends Exception{
    public MyException(String errorMessage){
        super("First exception" + errorMessage);
    }
}
