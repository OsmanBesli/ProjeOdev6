import java.util.ArrayList;
import java.util.List;

// Sipariş Sınıfı
public class Order {
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