package Models;

import java.util.ArrayList;

public class Customer {
    ArrayList<Order> orders;
    String customer_name;
    String customer_email;
    String customer_phone;

    public Customer(ArrayList<Order> orders, String customer_name, String customer_email, String customer_phone) {
        this.orders = orders;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return this.customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return this.customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }
}
