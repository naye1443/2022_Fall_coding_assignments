/* This is my Fibonacci sequence implmentation. I added the BigInteger Objects so that if wanted, the user could calculate higher numbers rather than 2^32 bits.
 * I also used a user input method, this would help with containing error checking
 */

import java.util.*;
import java.math.BigInteger;

public class Fib{

  // Constructor
  public Fib(BigInteger f0,BigInteger f1){
    this.f0 = f0;
    this.f1 = f1;
  }

  // Fibonacci numbers iteratively
  int fib_itr(int n){

    // Creates needed variables as BigIntegers
    int i = 0;
    BigInteger F_0 = f0;
    BigInteger F_1 = f1;
    BigInteger Ithfib = new BigInteger("0");
    while(i < n){
      if(i == 0){ // If first Fibonacci operation, use f(0) and f(1) as 0 and 1
        Ithfib = F_0.add(F_1);
      }else{
        BigInteger tempF_0 = Ithfib;
        Ithfib = Ithfib.add(F_0);
        F_0 = tempF_0;
      }
      i++;
    }

    System.out.println("The Fibonacci number at i = " + i + " is " + Ithfib);
    System.out.println("Iteratively Fibonacci works");
    
    return 0;
  }

  // Fibonacci numbers recursively
  BigInteger fib_recur(int n){
    // Sets F(1) and F(2) equal to -1(null)
    BigInteger F_1 = BigInteger.valueOf(-1);
    BigInteger F_2 = BigInteger.valueOf(-1);

    // Base case
    if(n == 0){
      return this.f0;
    }else if(n == 1){ // Base case
      return this.f1;
    }else{  // Determine F_1 and F_2 by recursively checking each possiblitity
      if(F_1.equals(BigInteger.valueOf(-1))){
        F_1 = fib_recur(n-1);
      }
      if(F_2.equals(BigInteger.valueOf(-1))){
        F_2 = fib_recur(n-2);
      }
    }
    return (F_1.add(F_2)); // Return computed sum back to called function
  }
  // To make this faster, could implment Dynamic programming to remember already calculated results.

  // Takes user input
  public BigInteger userInput(){
    // Initalizes variables and control variables
    BigInteger strn = BigInteger.valueOf(0);
    boolean correcVal = true;

    while(correcVal){
      // Takes in user input
      Scanner in = new Scanner(System.in);
      String n = in.nextLine();
      // Try to test if the string lined is an integer by trying to turn string into an int
      try{
        strn = BigInteger.valueOf(Integer.parseInt(n));
      } catch (Exception e){
        System.out.println("This value is not a integer");
        continue;
      }
      // If The converted string to int is a number, make sure the value is greater than 0
      if (strn.compareTo(BigInteger.ZERO) < 0){
        try{
          throw new ArithmeticException("This number is not greater than 0.");
        } catch (ArithmeticException e ){
          System.out.println("You can not have a number lower than 0");
          continue;
        }
      }

      in.close(); // Activate GC
      correcVal = false;
    }
    return strn;
  }

  // Main function to call different versions for Fibonacci number calculation
  public static void main(String[] args){
  //System.out.print("Please enter the n-Ith Fibonacci number you would like:");

  int[] intargs;
  intargs = new int[3];

  if (args.length < 3){
    System.out.println("You entered too few arguments. Please enter three arguments f(0) f(1) and n");
    System.exit(1);
  }
  try {
    for(int i = 0; i < args.length ;i++){
      intargs[i] = Integer.parseInt(args[i]);
    }
  }catch(NumberFormatException e){
    System.out.println("This is not a number!");
    System.exit(1);
  }catch(ArrayIndexOutOfBoundsException e){
    System.out.println("You have entered too many inputs");
    System.exit(1);
  }
  
  System.out.println("You have printed " + intargs[2]);

  Fib tempfib = new Fib(BigInteger.valueOf(intargs[0]),BigInteger.valueOf(intargs[1]));

  // BigInteger input = tempfib.userInput();

  tempfib.fib_itr(intargs[2]);
  tempfib.fib_recur(intargs[2]);

  System.out.println("End of main function");
  return;
  }

  BigInteger f0;
  BigInteger f1;
};