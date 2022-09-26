package pack;
import java.util.Scanner;


public class UPCscanner{

    public UPCscanner(){
        System.out.println("You can now scan your items, please enter a UPC number.");
    }

    /**
     * This class takes user input to simulate scanning an item
     * @param upc
     */
    public String scanitem(){
        Scanner in = new Scanner(System.in);
        String upc = in.nextLine();
        return upc;
    }
}