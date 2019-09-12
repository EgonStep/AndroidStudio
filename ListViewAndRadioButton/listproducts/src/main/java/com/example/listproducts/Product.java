package com.example.listproducts;

public class Product {

    private String name;
    private String type;
    private double amount;
    private boolean priority;

    public Product() {
    }

    public Product(String name, String type, double amount, boolean priority) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
