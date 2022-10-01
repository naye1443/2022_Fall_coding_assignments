package src;

public class Nvector {

  /**
   * @param n, the capacity of the vector
   * @precondition None
   * @postcondition The vector will be initalized with a capacity of n with 0's at each index, Nvector > 0
   * @invariant Nvector will always be > 0
   */
  public Nvector(int n) {
    vector = new double[n];
    System.out.println(vector[0]);
  }

  /**
   * @param n, this parameter is an arbitrary number of parameters. These parameters are then converted into a Nvector
   * @precondition None
   * @postcondition Nvector created with parameters passed to the constructor
   * @invariant
   */
  public Nvector(double... n) {
    vector = new double[n.length];
    for (int i = 0; i < n.length; i++) {
      vector[i] = n[i];
      System.out.println(n[i]);
    }
  }

  /**
   * @param vec, is another Nvector that will be coppied into this current's objects field
   * @precondition the parameter Nvector needs to be initalized and > 0
   * @postcondition the current object is not equivalent to the parameter Nvector
   */
  public Nvector(Nvector vec) {
    vector = new double[vec.length()];
    for (int i = 0; i < vec.length(); i++) {
      vector[i] = vec.get(i);
      System.out.println(vec.get(i));
    }
  }

  /**
   * @param i, is the index of a value in the Nvector
   * @return returns the value corresponding to the index
   * @precondition 0 < i < Nvector.size(), Nvector.size > 0
   * @postcondition The value at the index place is returned as a double
   */
  public double get(int i) {
    return vector[i];
  }

  /**
   * @return returns length of the Nvector
   * @precondition Nvector.size > 0
   * @postcondition the vectors length is returned as an int
   */
  public int length() {
    return vector.length;
  }

  /**
   * @param vec, another Nvector
   * @return Will return wheather current Nvector, and parameter Nvector are equivalent
   * @precondition For Nvectors to be considered to be equal, need to be same length,
   * @postcondition Nvectors will either be equivalent which is true returned, or vice versa
   */
  public boolean isEqual(Nvector vec) {
    if (this.length() != vec.length()) {
      return false;
    }
    for (int i = 0; i < this.length(); i++) {
      if (vector[i] != vec.get(i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param i, the index that will be replaced in the copy
   * @param x, the value that will replace the value at index I
   * @return a new Nvector with the value at that index replaced with x
   * @precondition The current Nvector > 0, 0 <= i < Nvector.length() - 1
   * @postcondition, same as @return
   */
  public Nvector set(int i, double x) {
    if (i >= 0 && i < vector.length) {
      double temparry[] = new double[vector.length];

      for (int z = 0; z < vector.length; z++) {
        if (i == z) {
          temparry[i] = x;
        } else {
          temparry[z] = this.get(z);
        }
      }
      return new Nvector(temparry);
    } else {
      System.out.println("You have not choosen a valid index");
      System.exit(1);
    }
    return null;
  }

  /**
   * @precondition Nvector > 0, this.length() == vec.length()
   * @param vec another Nvector that will be added to current Nvector
   * @return returns a new Nvector that is the sum of both Nvectors
   * @postcondition new Nvect with sum of both Nvectors
   */
  public Nvector add(Nvector vec){
    if(this.length() == vec.length()){
      double tempary[] = new double[vector.length];
      for(int i = 0; i < vector.length; i++){
        tempary[i] = vector[i] + vec.get(i);
      }
      return new Nvector(tempary);
    }
    System.out.println("These two Nvectors are not the same size");
    System.exit(1);
    return null;
  }

  /**
   * @precondition Nvector > 0, this.length() == vec.length()
   * @param vec Nvector that will be multiplied by another Nvector
   * @return the product of the Nvectors indexes summed up
   * @postCondition same as @return
   */
  public double sprod(Nvector vec){
    if(this.length() == vec.length()){
      double sprod = 0.0;
      for(int i = 0; i < vector.length; i++){
        sprod += vector[i] * vec.get(i);
      }
      return sprod;
    }
    System.out.println("These two Nvectors are not the same size");
    System.exit(1);
    return 0.0;
  }

  /**
   * @precondition Nvector > 0
   * @return returns a string that has all elements of Nvector
   * @postcondition Same as @return
   */
  public String toString(){
    String tostr = "[";
    for(int i = 0; i < vector.length; i++){
      if(i == 0){
        tostr += Double.toString(vector[i]);
      }else {
        tostr += "," + Double.toString(vector[i]);
      }
    }
    tostr += "]";
    return tostr;
  }

  public static void main(String[] args) {
    Nvector test = new Nvector(5);

    Nvector test2 = new Nvector(9, 3, 2, 1, 5, 3);

    Nvector test3 = new Nvector(test2);

    System.out.println(test3.isEqual(test3));
    System.out.println(test3.isEqual(test));

    System.out.println("end of boolean testing");

    Nvector test4 = test3.set(2, 5.6);

    System.out.println("end of set testing");

    test4.add(test3);

    System.out.println("end of set testing");

    Nvector prodtest = new Nvector(1,1,1,1,1);
    Nvector prodtest1 = new Nvector(3,1,5,6,9);
    System.out.println(prodtest.sprod(prodtest1));

    System.out.println("end of sprod testing");
    System.out.println(test4.toString());
    return;
  }

  private double[] vector;
};