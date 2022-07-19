public class Exceptions {
    public static void method1(){
        System.out.println("Method 1 called!");
        try {
            method2();
        }
        catch(Exception exception){
            System.out.println("\nExceptions caused by:");
            exception.printStackTrace();
        }
    }

    public static void method2() throws MyException2{
        System.out.println("Method 2 called!");
        try {
            method3();
        }
        catch(Exception exception){
            throw new MyException2("thrown at method2");
        }
    }

    public static void method3() throws MyException{
        System.out.println("Method 3 called!");
        method4();
    }

    public static void method4() throws MyException{
        System.out.println("Method 4 called!");
        throw new MyException("thrown at method4");
    }
}
