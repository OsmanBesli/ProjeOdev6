import java.util.ArrayList;
import java.util.List;

// Kullanıcı Sınıfı
public class User {
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