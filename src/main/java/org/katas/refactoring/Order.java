package org.katas.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String addr;
    private List<LineItem> lineItems;

    public Order(String nm, String addr, List<LineItem> li) {
        this.customerName = nm;
        this.addr = addr;
        this.lineItems = li;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
