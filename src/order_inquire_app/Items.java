/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order_inquire_app;

/**
 *
 * @author Admin
 */
public class Items {
    
    private int ItemID;
    private String ItemName, ItemDescription; 
    private String ItemBrand, ItemMadeIn;
    private double ItemPrice;
    
    public Items(int ItemID, String ItemName, String ItemDescription,String ItemBrand, String ItemMadeIn, double ItemPrice){
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.ItemDescription = ItemDescription;
        this.ItemBrand = ItemBrand;
        this.ItemMadeIn = ItemMadeIn;
        this.ItemPrice = ItemPrice;
    }

    /**
     * @return the ItemID
     */
    public int getItemID() {
        return ItemID;
    }

    /**
     * @param ItemID the ItemID to set
     */
    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    /**
     * @return the ItemName
     */
    public String getItemName() {
        return ItemName;
    }

    /**
     * @param ItemName the ItemName to set
     */
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    /**
     * @return the ItemDescription
     */
    public String getItemDescription() {
        return ItemDescription;
    }

    /**
     * @param ItemDescription the ItemDescription to set
     */
    public void setItemDescription(String ItemDescription) {
        this.ItemDescription = ItemDescription;
    }

    /**
     * @return the ItemBrand
     */
    public String getItemBrand() {
        return ItemBrand;
    }

    /**
     * @param ItemBrand the ItemBrand to set
     */
    public void setItemBrand(String ItemBrand) {
        this.ItemBrand = ItemBrand;
    }

    /**
     * @return the ItemMadeIn
     */
    public String getItemMadeIn() {
        return ItemMadeIn;
    }

    /**
     * @param ItemMadeIn the ItemMadeIn to set
     */
    public void setItemMadeIn(String ItemMadeIn) {
        this.ItemMadeIn = ItemMadeIn;
    }

    /**
     * @return the ItemPrice
     */
    public double getItemPrice() {
        return ItemPrice;
    }

    /**
     * @param ItemPrice the ItemPrice to set
     */
    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

   
    
    
}
