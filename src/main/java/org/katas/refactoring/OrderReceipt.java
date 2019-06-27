package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order o) {
        this.order = o;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        printHeaders(output);

        // print date, bill no, customer name
        printCustomerNameAndAddress(output);

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printLineItem(output, lineItem);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        printSalesTax(output, totSalesTx);

        // print total amount
        printTotalAmount(output, tot);
        return output.toString();
    }

    private void printLineItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private StringBuilder printTotalAmount(StringBuilder output, double tot) {
        return output.append("Total Amount").append('\t').append(tot);
    }

    private StringBuilder printSalesTax(StringBuilder output, double totSalesTx) {
        return output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void printCustomerNameAndAddress(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }
}