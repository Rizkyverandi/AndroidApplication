package com.example.user.binusezyfoody;

/**
 * Created by USER on 07/11/2020.
 */

public class DrinkList {
    private String drink_name;
    private String qty;
    private int imgId;

    public DrinkList(String drink_name, String qty, int imgId) {
        this.drink_name = drink_name;
        this.qty = qty;
        this.imgId = imgId;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public String getQty() {
        return qty;
    }

    public int getImgId() {
        return imgId;
    }
}
