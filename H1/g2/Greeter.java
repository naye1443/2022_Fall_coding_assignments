//package H1.g2;

public class Greeter {
    public Greeter(String Name){    // Sets name of greeter
        name = Name;
    }

    // Prints hello and then name
    public String sayHello(){
        return "Hello, " + name + "!";
    }

    // Swaps a Greeter object's name with its own
    public void swapNames(Greeter other){

            String tempname = other.name;
            other.name = this.name;
            this.name = tempname;
    }

    // Creates a new Greeter and returns it with its name and the current Greeters name Concatonated
    public Greeter createQualifiedGreeter(String qualifier){
        return new Greeter(qualifier + " " + this.name);
    }

    public static void main(String[] args){

        Greeter g = new Greeter("Eyan");
        Greeter g1 = new Greeter("Taniya");

        System.out.println("g is " + g.name);
        System.out.println("g1 is " + g1.name);

        g.swapNames(g1);

        System.out.println("g is " + g.name);
        System.out.println("g1 is " + g1.name);

        Greeter g2 = g.createQualifiedGreeter("Cool");

        System.out.println("g2 is " + g2.name);
    }

    private String name;
};
