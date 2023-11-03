package ua.hillel.stolitnii.homeworks.homework13;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 300, false, LocalDate.of(2022, 1, 15)));
        products.add(new Product("Book", 200, true, LocalDate.of(2022, 2, 10)));
        products.add(new Product("Toy", 100, true, LocalDate.of(2022, 2, 5)));
        products.add(new Product("Book", 150, true, LocalDate.of(2023, 3, 20)));

        List<Product> expensiveBooks = products.stream()
                .filter(p -> "Book".equals(p.getType()) && p.getPrice() > 250)
                .collect(Collectors.toList());

        System.out.println("Expensive Books: " + expensiveBooks);

        List<Product> discountedBooks = products.stream()
                .filter(p -> "Book".equals(p.getType()) && p.hasDiscount())
                .map(p -> new Product(p.getType(), p.getPrice() * 0.9, p.hasDiscount(), p.getCreateDate()))
                .collect(Collectors.toList());

        System.out.println("Discounted Books: " + discountedBooks);

        Optional<Product> cheapestBook = products.stream()
                .filter(p -> "Book".equals(p.getType()))
                .min(Comparator.comparing(Product::getPrice));

        if (cheapestBook.isPresent()) {
            System.out.println("Cheapest Book: " + cheapestBook.get());
        } else {
            throw new RuntimeException("Продукт [категорія: Book] не знайдено");
        }

        List<Product> latestProducts = products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Latest Products: " + latestProducts);

        double totalCost = products.stream()
                .filter(p -> "Book".equals(p.getType()) && p.getCreateDate().getYear() == LocalDate.now().getYear() && p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total Cost: " + totalCost);

        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getType));

        System.out.println("Grouped Products: " + groupedProducts);
    }
}
