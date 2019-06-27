package org.katas.refactoring;

public class LineItem {
    private String desc;
    private double price;
    private int quantity;

    public LineItem(String desc, double p, int qty) {
        super();
        this.desc = desc;
        this.price = p;
        this.quantity = qty;
    }

    public String getDescription() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }
}