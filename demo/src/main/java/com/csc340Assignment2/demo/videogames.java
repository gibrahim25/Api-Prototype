package com.csc340Assignment2.demo;

public class videogames {
    public String name;
    public int storeID;
    public int salePrice;


    public videogames(String name, int storeID, int salePrice) {

        this.name = name;
        this.storeID = storeID;
        this.salePrice = salePrice;


    }
    public String getInternalName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;

    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }


}

