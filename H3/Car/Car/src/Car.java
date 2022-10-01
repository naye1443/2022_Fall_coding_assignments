import java.util.*;
import java.util.Collections;


public class Car {

  /**
   * @precondition, none
   * @postcondition, object's attributes are initalized
   * @param make, is the make of the car (Toyota, Ford)
   * @param model, is the model of the car (Corolla, Bronco)
   * @param whenBuilt, is the date when the car was built
   */
  public Car(String make, String model, Date whenBuilt){
    this.make = make;
    this.model = model;
    this.whenBuilt = whenBuilt;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args){
      Date carDate = new Date((long)1104541261);
      Date carDate1 = new Date((long)1102938912);
      Date carDate2 = new Date((long)1102387823);
      Date carDate3 = new Date((long)1103872093);

      ArrayList<Car> CarArray = new ArrayList<Car>();
      Car currcar = new Car("Toyota", "Corolla", carDate);
      Car currcar1 = new Car("Ford", "F150", carDate1);
      Car currcar2 = new Car("Nissan", "Altima", carDate2);
      Car currcar3 = new Car("Toyota", "Rav4", carDate3);

      CarArray.add(currcar);
      CarArray.add(currcar1);
      CarArray.add(currcar2);
      CarArray.add(currcar3);

      Comparator<Car> carcomparator = Car.getCompByMakeModel();
      Comparator<Car> carDatecomparator = Car.getCompByDate();

      Collections.sort(CarArray, carcomparator);

      for(Car cariter : CarArray) {
          cariter.toStrinG();
          System.out.println("--------------------------------------------");
      }

      System.out.println("*****************************************************");
      Collections.sort(CarArray, carDatecomparator);

      for(Car cariter : CarArray) {
          cariter.toStrinG();
          System.out.println("--------------------------------------------");
      }
  }

  /**
   * @precondition, make needs to be initalized
   * @postcondition, none
   * @return returns make of current Car
   */
  public String getmake(){
    return this.make;
  }

  /**
   * @precondition, model needs to be initalized
   * @postcondition, none
   * @return returns model of current Car
   */
  public String getmodel(){
    return this.model;
  }

  /**
   * @precondition, Date needs to be initalized
   * @postcondition, a cloned date is returned
   * @return returns a clone of when the Car was built
   */
  public Date getwhenBuilt(){
    return (Date)this.whenBuilt.clone();
  }

  /**
   * @precondition, Make, model, and Date when built needs to be returned
   * @postcondition, none
   */
  public void toStrinG(){
    System.out.println("make:" + this.make + "\nModel: " + this.model + "\nWhen Built: " + this.getwhenBuilt());
  }

  /**
   * @precondition, none
   * @postcondition, none
   * @return returns a Comparator object for comparison of cars by Make & Model
   */
  public static java.util.Comparator<Car> getCompByMakeModel(){
    return new Comparator<Car>(){
      public int compare(Car car1, Car car2){
        String car1comp = car1.getmake() + " " + car1.getmodel();
        String car2comp = car2.getmake() + " " + car2.getmodel();
        return car1comp.compareTo(car2comp);
      }
    };
  }
  /**
   * @precondition, none
   * @postcondition, none
   * @return returns a Comparator object for comparison of cars by Date
   */
  public static java.util.Comparator<Car> getCompByDate(){
    return new Comparator<Car>(){
      public int compare(Car car1, Car car2){
        return car1.getwhenBuilt().compareTo(car2.getwhenBuilt());
      }
    };
  }

  private String make;
  private String model;
  private Date whenBuilt;
}
