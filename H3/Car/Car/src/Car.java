import java.util.Date;
import java.util.Comparator;

public class Car {

  public Car(String make, String model, Date whenBuilt){
    this.make = make;
    this.model = model;
    this.whenBuilt = whenBuilt;
  }

  public static void main(String[] args){

  }

  public String getmake(){
    return this.make;
  }

  public String getmodel(){
    return this.model;
  }

  public Date getwhenBuilt(){
    return (Date)this.whenBuilt.clone();
  }

  public toString(){
    System.out.println("make:" + this.make + "\nModel: " + this.model + "\n" );
  }

  public static java.util.Comparator<Car> getCompByMakeModel(){

    return new Comparator<Car>() {
      public int compare(Car car1, Car car2){
        String car1comp = car1.getmake() + " " + car1.getmodel();
        String car2comp = car2.getmake() + " " + car2.getmodel();
        return car1comp.compareTo(car2comp);
      }
    };

  }

  private String make;
  private String model;
  private Date whenBuilt;
}
