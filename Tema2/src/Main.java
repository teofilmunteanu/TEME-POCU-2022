import java.util.Scanner;

public class Main {
    public static void flowControlExamples(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Compute factorial for: ");
        int nr1 = sc.nextInt();
        System.out.println("Factorial of " + nr1 + ": " + FlowControl.factorial(nr1) + "\n");

        System.out.print("Compute fibonnaci for n: ");
        int nr2 = sc.nextInt();
        System.out.println(nr2 + "-th fibonnaci number: " + FlowControl.fibonacci(nr2) + "\n");

        System.out.print("Check if number is prime: ");
        int nr3 = sc.nextInt();
        System.out.println(nr3 + " is " + (FlowControl.isPrime(nr3)?"prime":"not prime") + "\n");

        System.out.print("Check if text is a palindrome:");
        sc.next();
        String text = sc.nextLine();
        System.out.println(text + " is " + (FlowControl.isPalindrome(text)?"a palindrome":"not a palindrome") + "\n");
    }

    public static void exceptionsExamples(){
        Exceptions.method1();
    }

    public static void main(String[] args) {
        flowControlExamples();
        exceptionsExamples();
    }
}