package com.example.vk11;

public class Product implements Comparable<Product>{
    String name;
    int order;

    public static int productOrder = 0;


    public Product(String name) {
        this.name = name;
        this.order = productOrder++;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public int getOrder(){
        return order;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return this.name.compareTo(otherProduct.getName());
    }
}
