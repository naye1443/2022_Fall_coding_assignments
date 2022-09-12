//package H1.g4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class PrimeFactorizer {
 
  public static void main(String[] args){
    int n = 0;

    if(args.length > 1){
      System.out.println("Please only enter one value");
      System.exit(1);
    }
    for(int i = 0; i < args.length; i++){
      try{
        n = Integer.parseInt(args[i]);
      }catch( NumberFormatException e){
        System.out.println("Please only enter a number");
        System.exit(1);
      }
    }

    PrimeFactorizer curr = new PrimeFactorizer(n);
    curr.compute();

    System.out.println(curr.toString());
  }

  /** 
   * Initialize the object with target number n. 
   */
  public PrimeFactorizer(int n) {
    target = n;
    base = new ArrayList<Integer>();
    exponent = new ArrayList<Integer>();
  } 
  
  /**
   * Return n, the target number.
   */
  public int getN() {
    return target;
  }
  
  /**
   * Compute factorization. Do not repeat operation if it was called before.
   */
  public void compute(){
    int temptarget = target;  // stores target into a temp target
    ArrayList<Integer> primeFactors = new ArrayList<>();  // List of all prime factors
    int i = 2; // starts loop at 2
    
    while(i < temptarget){
      if(temptarget % i == 0){  // If temptarget's remainder is equal to 0...
        primeFactors.add(Integer.valueOf(i)); // add i as a primeFactor
        temptarget = temptarget / i;  // set temptarget to quotient of curr temptarget for next check
        i = 2;  // rest 2
      }else{  // if remainder is not equal, iterate i by one to try next factor
        i++;
      }
    }
    primeFactors.add(Integer.valueOf(temptarget));  // add last factor to prime Factors
    Collections.sort(primeFactors);

    for(int z = 0; z < primeFactors.size(); z++){
      if(base.isEmpty()){
        base.add(primeFactors.get(z));
      }else if(!base.contains(primeFactors.get(z))){
        base.add(primeFactors.get(z));
      }
    }
    // base now has all sorted unique factors, the index of these will show frequency of factors
    for( int z = 0; z < base.size(); z++){
      exponent.add(Collections.frequency(primeFactors, base.get(z)));
    }

  }
  
  /**
   * Return the factors and exponents in two arraylists. Call compute() first, if necessary.
   * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
   * This function overwrites the 'n' parameter passed to the constructor.
   */
  // public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
  //   ....
  // }
  
  
  /**
   * Return a string with the "pretty" representation of the prime factorization.
   * For instance, if n is 60, then toString() for the PrimeFactorizer(60) object
   * should be "60 = 2^2*3*5". Call compute() if not done before.
   */
  public String toString(){
    
    String factorstr = "";
    for( int i = 0; i < base.size(); i++){

      if (exponent.get(i) == 1 && i == 0){
        factorstr = factorstr + String.valueOf(base.get(i));
      }else if(exponent.get(i) > 1 && i == 0){
        factorstr = factorstr + String.valueOf(base.get(i)) + "^" + String.valueOf(exponent.get(i));
      }else if(exponent.get(i) > 1){
        factorstr = factorstr + "*" + String.valueOf(base.get(i)) + "^" + String.valueOf(exponent.get(i));
      }else{
        factorstr = factorstr + "*" + String.valueOf(base.get(i));
      }
    }
    return factorstr;
  }
  
  private int target;
  private ArrayList<Integer> base;
  private ArrayList<Integer> exponent;
}
