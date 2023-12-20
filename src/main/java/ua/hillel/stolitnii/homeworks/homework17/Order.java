package ua.hillel.stolitnii.homeworks.homework17;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private String date;
    private double cost;
    private List<Product> products;

    public Order(int id, String date, double cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}
