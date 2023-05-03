package ru.netology.jdbctask1.repository;

public class Orders {
    private int id;
    private String date;
    private String product_name;
    private int amount;

    public Orders(int id, String date, String product_name, int amount) {
        this.id = id;
        this.date = date;
        this.product_name = product_name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id+" "+date+" "+product_name+" "+amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
