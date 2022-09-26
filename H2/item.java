package pack;

public class item {
    public item(String upc, String name, String unitPrice){
        this.upc = upc;
        this.unitPrice = unitPrice;
        this.name = name;
    }

    public String name;
    public String upc;
    public String unitPrice;
}
