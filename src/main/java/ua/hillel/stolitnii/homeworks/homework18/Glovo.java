package ua.hillel.stolitnii.homeworks.homework18;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class Glovo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Glovo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        createTablesIfNotExist();
    }

    @Transactional
    public void createTablesIfNotExist() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS orders (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "date VARCHAR(255)," +
                "cost DOUBLE)");

        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS products (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255)," +
                "cost DOUBLE," +
                "order_id INT," +
                "FOREIGN KEY (order_id) REFERENCES orders(id))");
    }

    @Transactional
    public void addOrder(Order order) {
        jdbcTemplate.update("INSERT INTO orders (date, cost) VALUES (?, ?)",
                order.getDate(), order.getCost());

        for (Product product : order.getProducts()) {
            addProduct(product, getLastInsertedOrderId());
        }
    }

    private void addProduct(Product product, int orderId) {
        jdbcTemplate.update("INSERT INTO products (name, cost, order_id) VALUES (?, ?, ?)",
                product.getName(), product.getCost(), orderId);
    }

    public List<Order> getAllOrders() {
        return jdbcTemplate.query("SELECT * FROM orders", new OrderMapper());
    }

    public Order getOrderById(int orderId) {
        return jdbcTemplate.queryForObject("SELECT * FROM orders WHERE id = ?", new OrderMapper(), orderId);
    }

    @Transactional
    public void updateOrder(Order order) {
        jdbcTemplate.update("UPDATE orders SET date = ?, cost = ? WHERE id = ?",
                order.getDate(), order.getCost(), order.getId());

        jdbcTemplate.update("DELETE FROM products WHERE order_id = ?", order.getId());

        for (Product product : order.getProducts()) {
            addProduct(product, order.getId());
        }
    }

    @Transactional
    public void deleteOrder(int orderId) {
        jdbcTemplate.update("DELETE FROM products WHERE order_id = ?", orderId);
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", orderId);
    }

    private int getLastInsertedOrderId() {
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }
}
