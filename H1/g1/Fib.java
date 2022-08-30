import java.util.*;


public class Fib{

  //Constructor
  public Fib(/*int f0, int f1*/){
  }

  //Fibonacci numbers iteratively
  int fib_itr(int n){

    Scanner in = new Scanner(System.in);
    n = in.nextInt();

    if (n < 0){
      try{
        throw new ArithmeticException("This number is not greater than 0.");
      } catch (ArithmeticException e){
        System.out.println("You can not have a number lower than 0");
      }
    }else{
      System.out.println("This number is greater than 0");
    }

    

    return 0;
  }

  //Fibonacci numbers recursively

  //Main function to call different versions for Fibonacci number calculation
  public static void main(String[] args){
    System.out.println("This is a cool funciton, lets get this started");
    Fib tempfib = new Fib();
    tempfib.fib_itr(-3);

    System.out.println("This is an exception");
    return;
  }
};