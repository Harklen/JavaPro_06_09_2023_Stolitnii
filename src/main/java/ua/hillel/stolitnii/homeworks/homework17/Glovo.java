package ua.hillel.stolitnii.homeworks.homework17;

import java.util.ArrayList;
import java.util.List;

public class Glovo {
    private List<Order> orders;

    public Glovo() {
        this.orders = new ArrayList<>();
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void editOrder(int orderId, Order newOrder) {
        Order existingOrder = getOrderById(orderId);
        if (existingOrder != null) {
            existingOrder.setDate(newOrder.getDate());
            existingOrder.setCost(newOrder.getCost());
            existingOrder.setProducts(newOrder.getProducts());
        }
    }

    public void deleteOrder(int orderId) {
        Order orderToRemove = getOrderById(orderId);
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
        }
    }


    public static void main(String[] args) {
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);
        Product product3 = new Product(3, "Product 3", 30.0);
        Product product4 = new Product(4, "Product 4", 40.0);
        Product product5 = new Product(5, "Product 5", 50.0);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Order order1 = new Order(1, "2023-01-21", 30.0, products);
        Order order2 = new Order(1, "2023-05-01", 60.0, products);
        Order order3 = new Order(1, "2023-05-07", 70.0, products);
        Order order4 = new Order(1, "2023-06-08", 90.0, products);

        Glovo glovo = new Glovo();
        glovo.addOrder(order1);
        glovo.addOrder(order2);
        glovo.addOrder(order3);
        glovo.addOrder(order4);

        Order retrievedOrder = glovo.getOrderById(1);
        System.out.println("Retrieved Order: " + retrievedOrder);

        List<Order> allOrders = glovo.getAllOrders();
        System.out.println("All Orders: " + allOrders);

        Order editedOrder = new Order(1, "2023-01-02", 35.0, products);
        glovo.editOrder(1, editedOrder);

        glovo.deleteOrder(1);
        allOrders = glovo.getAllOrders();
        System.out.println("Orders after deletion: " + allOrders);
    }
}