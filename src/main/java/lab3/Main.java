package lab3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
 public static void main(String[] args) {
    List <Employee> employees = List.of(
            new Employee.Builder()
                    .setName("Ivan")
                    .setSalary(1000)
                    .setAddress("Kyiv")
                    .setPosition("Cleaner")
                    .build(),
            new Employee.Builder()
                    .setName("Petro")
                    .setSalary(2000)
                    .setAddress("Lviv")
                    .setPosition("Seller")
                    .build(),
            new Employee.Builder()
                    .setName("Alex")
                    .setSalary(3000)
                    .setAddress("Kharkiv")
                    .setPosition("Manager")
                    .build(),
            new Employee.Builder()
                    .setName("Vasyl")
                    .setSalary(5000)
                    .setAddress("Dnipro")
                    .setPosition("Seller")
                    .build(),
            new Employee.Builder()
                    .setName("Taras")
                    .setSalary(4000)
                    .setAddress("Odesa")
                    .setPosition("Manager")
                    .build());
    ProductCategory[] productCategories = new ProductCategory[]{
            new ProductCategory.Builder()
                    .setName("Food")
                    .setProducts(new Product[]{
                            new Product.Builder()
                                    .setName("Bread")
                                    .setPrice(10)
                                    .build(),
                            new Product.Builder()
                                    .setName("Milk")
                                    .setPrice(20)
                                    .build(),
                            new Product.Builder()
                                    .setName("Meat")
                                    .setPrice(30)
                                    .build()
                    })
                    .build(),
            new ProductCategory.Builder()
                    .setName("Drinks")
                    .setProducts(new Product[]{
                            new Product.Builder()
                                    .setName("Water")
                                    .setPrice(10)
                                    .build(),
                            new Product.Builder()
                                    .setName("Juice")
                                    .setPrice(20)
                                    .build(),
                            new Product.Builder()
                                    .setName("Beer")
                                    .setPrice(30)
                                    .build()
                    })
                    .build(),
            new ProductCategory.Builder()
                    .setName("Clothes")
                    .setProducts(new Product[]{
                            new Product.Builder()
                                    .setName("T-shirt")
                                    .setPrice(10)
                                    .build(),
                            new Product.Builder()
                                    .setName("Pants")
                                    .setPrice(20)
                                    .build(),
                            new Product.Builder()
                                    .setName("Shoes")
                                    .setPrice(30)
                                    .build()
                    })
                    .build()
    };
    Shop shop = new Shop.Builder()
            .setName("Shop")
            .setAddress("Ukraine")
            .setEmployees(employees.toArray(new Employee[0]))
            .setProductCategories(new ProductCategory[0])
            .build();
    System.out.println(shop);
    System.out.println("Product categories:");
    for (ProductCategory productCategory : productCategories) {
        System.out.println(productCategory);
    }
    System.out.println("Most expensive product:");
    Product product = Collections.max(List.of(productCategories).stream()
            .flatMap(productCategory -> List.of(productCategory.getProducts()).stream())
            .collect(Collectors.toList()), Comparator.comparing(Product::getPrice));
    System.out.println(product);
    System.out.println("Employees with salary more than 2000:");
    employees.stream()
            .filter(employee -> employee.getSalary() > 2000)
            .forEach(System.out::println);
    System.out.println("Employees with salary more than 2000 sorted by salary:");
    employees.stream()
            .filter(employee -> employee.getSalary() > 2000)
            .sorted(Comparator.comparingInt(Employee::getSalary))
            .forEach(System.out::println);
    System.out.println("Middle salary:");
    System.out.println(employees.stream()
            .mapToInt(Employee::getSalary)
            .average()
            .orElse(0));
 }
}
