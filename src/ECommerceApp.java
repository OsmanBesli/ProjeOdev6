import java.util.*;


// Ana Program
public class ECommerceApp {
    public static void main(String[] args) {

        ECommerceApp eCommerceApp = new ECommerceApp();
        eCommerceApp.baslat();

    }

    private void baslat() {

        User user = new User("ali", "1234");
        Product p1 = new Product("Laptop", 15000);
        Product p2 = new Product("Telefon", 10000);

        user.addToCart(p1);
        user.addToCart(p2);

        Order order = new Order(user);
        order.displayOrderDetails();
    }
}