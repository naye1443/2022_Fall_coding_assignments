package pack;

import java.util.ArrayList;
import pack.item;

public class StoreSystem {

    /**
     * Is initalized when Register is initalized
     * an empty ArrayList is initalized, and total of cart is set to 0.0
     */
    public StoreSystem(){
        items = new ArrayList<item>();
        itemDB = new ArrayList<item>();
        total = 0.0;
    }

    /**
     * add an item with the UPC into the array list
     * @param upc
     * @param name
     * @param unitPrice
     */
    public void additem(String upc, String name, String unitPrice){
        item tempitem = new item(upc,name,unitPrice);
        itemDB.add(tempitem);
    }

    /**
     * Add an item to the list current customers list. If the item is not in the itemDB, then @return return false
     * else if the item is in the itemDB, then return true
     * @param upc
     */
    public Boolean additemtoList(String upc){
        if(upc == "q" || upc == "Q"){
            return false;
        }
        for(int i = 0; i < itemDB.size(); i++){
            if(upc.equals(itemDB.get(i).upc)){  // if given upc is equal to any items.upc in itemDB then return true
                items.add(new item(itemDB.get(i).upc,itemDB.get(i).name,itemDB.get(i).unitPrice));
                total += Double.parseDouble(itemDB.get(i).unitPrice);   // then add the unit price to the total
                return true;
            }
        }
        return false;
    }

    /**
     * extends Register and gets unitprice, name and upc
     */
    public String[] getUPC(String upc){
        String[] iteminfo = new String[3];

        for(int i = 0; i < itemDB.size(); i++){
            if(upc.equals(itemDB.get(i).upc)){
                iteminfo[0] = itemDB.get(i).name;
                iteminfo[1] = itemDB.get(i).upc;
                iteminfo[2] = itemDB.get(i).unitPrice;

                return iteminfo;
            }
        }
        return new String[]{"0","0","0"};   // if item is not found, then return array [0,0,0]
    }

    public ArrayList<item> items;
    public ArrayList<item> itemDB;
    public double total;
}
