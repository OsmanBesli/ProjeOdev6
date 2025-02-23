import java.util.*;
// Ürün Sınıfı
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
// Kullanıcı Sınıfı
class User {
    String username;
    private String password;
    private List<Product> cart;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }
}
// Sipariş Sınıfı
class Order {
    private User user;
    private List<Product> products;
    private double totalAmount;

    public Order(User user) {
        this.user = user;
        this.products = new ArrayList<>(user.getCart());
        this.totalAmount = calculateTotal();
    }
    private double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void displayOrderDetails() {
        System.out.println("Sipariş Sahibi: " + user.username);
        System.out.println("Ürünler:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " : " + p.getPrice() + " TL");
        }
        System.out.println("Toplam Tutar: " + totalAmount + " TL");
    }
}
// Ana Program
public class ECommerceApp {
    public static void main(String[] args) {
        User user = new User("ali", "1234");
        Product p1 = new Product("Laptop", 15000);
        Product p2 = new Product("Telefon", 10000);

        user.addToCart(p1);
        user.addToCart(p2);

        Order order = new Order(user);
        order.displayOrderDetails();
    }
}