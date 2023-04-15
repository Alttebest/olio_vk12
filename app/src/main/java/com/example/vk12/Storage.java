package com.example.vk12;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Product> products = new ArrayList<>();
    private static Storage storage = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void changeText(int position){

    }
}
