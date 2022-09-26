import pack.StoreSystem;
import pack.UPCscanner;

public class Register{

    /**
     * This initalizes register. Creates a UPCscanner that is running throughout the life of the register
     */
    public Register(){
        System.out.println("Please Enter q or Q when you want to checkout");
        initscanner = new UPCscanner();  // creates a new scanner object
        initStoreSystem = new StoreSystem();
        checkout = false;
    }

    /**
    * This is the entry point into the program.
    */
    public static void main(String[] args){
        Register initReg = new Register();

        initReg.initStoreSystem.additem("123123122341","Pickles","1.30");
        initReg.initStoreSystem.additem("902349232312","Pizza","8.75");
        initReg.initStoreSystem.additem("809234231231","Chicken Breast","10.45");
        initReg.initStoreSystem.additem("908221423423","Bread","3.47");
        initReg.initStoreSystem.additem("678121332191","eggs","4.37");
        initReg.initStoreSystem.additem("234812903231","icecream","4.65");
        initReg.initStoreSystem.additem("798123361235","milk","3.97");

        while(!initReg.checkout) {


            String curr = initReg.initscanner.scanitem();

            if (!initReg.initStoreSystem.additemtoList(curr)){    // Adds item to customers cart
                initReg.pay();
                continue;
            }
            initReg.print_UPC_name_unitPrice(initReg.getUPC(curr)); // prints item name, upc, and unit price after each scan

        }
        initReg.Displaytotal();

    }

    /**
     * gets calls StoreSystem to get info about item with UPC number
     */
    public String[] getUPC(String upc){
        return initStoreSystem.getUPC(upc);
    }

    /**
    * Displays all items purchased with upc, name, unitprice, and total
     */
    public void Displaytotal(){

        System.out.println("Thank you for paying, here is your receipt");
        String[] tempitem = new String[3];
        for(int i = 0; i < this.initStoreSystem.items.size(); i++){
            tempitem[1] = this.initStoreSystem.items.get(i).upc;
            tempitem[0] = this.initStoreSystem.items.get(i).name;
            tempitem[2] = this.initStoreSystem.items.get(i).unitPrice;
            print_UPC_name_unitPrice(tempitem);
        }
        System.out.println("The total of your cart is: " + this.initStoreSystem.total);
    }

    /**
     * Is called when Customer is ready to pay for their total
     */
    public void pay(){
        checkout = true;    // sets checkout equal to true
    }

    /**
     * Prints item info back to console/register responses to customer
     * @param iteminfo
     */
    public void print_UPC_name_unitPrice(String[] iteminfo){
        System.out.println("******************************************************************");
        System.out.println("item name: " + iteminfo[0] + "\nitem UPC: " + iteminfo[1] + "\nitem Unit Price: " + iteminfo[2]);
        System.out.println("******************************************************************");
    }

    public UPCscanner initscanner;  // stores UPC scanner object
    public StoreSystem initStoreSystem; // stores StoreSystem
    boolean checkout;               // changes state of register so customer can checkout

}