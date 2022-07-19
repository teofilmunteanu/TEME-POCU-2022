public class FlowControl {
    public static long factorial(int n)
    {
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static long fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static boolean isPrime(int n){
        if(n==0 || n==1){
            return false;
        }

        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String text){
        for(int i=0;i<text.length()/2;i++){
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }
}
