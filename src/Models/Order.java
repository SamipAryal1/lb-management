package Models;

import java.util.Iterator;
import java.util.List;

public class Order {
    private List<BookOrder> bookOrders;
    private double vatRate;
    private double discountRate;
    private Customer customer;
    private double totalPrice;

    public Order(List<BookOrder> bookOrders, double vatRate, double discountRate, Customer customer) {
        this.bookOrders = bookOrders;
        this.vatRate = vatRate;
        this.discountRate = discountRate;
        this.customer = customer;
        this.totalPrice = this.calculateTotalPrice();
    }

    public double calculateTotalPrice() {
        double total = 0.0;

        BookOrder bookOrder;
        for(Iterator var3 = this.bookOrders.iterator(); var3.hasNext(); total += bookOrder.calculateTotalPrice()) {
            bookOrder = (BookOrder)var3.next();
        }

        return total;
    }

    public double calculateVat() {
        return this.totalPrice * (this.vatRate / 100.0);
    }

    public double calculateDiscount() {
        return this.totalPrice * (this.discountRate / 100.0);
    }

    public double calculateFinalPrice() {
        return this.totalPrice + this.calculateVat() - this.calculateDiscount();
    }

    public List<BookOrder> getBookOrders() {
        return this.bookOrders;
    }

    public void setBookOrders(List<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
        this.totalPrice = this.calculateTotalPrice();
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getVatRate() {
        return this.vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public double getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
