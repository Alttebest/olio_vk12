package com.example.vk12;

public class Product implements Comparable<Product>{
    String name;
    int order;
    Boolean important;

    public static int productOrder = 0;


    public Product(String name, Boolean important) {
        this.name = name;
        this.order = productOrder++;
        this.important = important;
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

    public Boolean getImportant(){
        return important;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return this.name.compareTo(otherProduct.getName());
    }
}
