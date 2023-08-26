package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Client {
    private final String name;
    private int yearRegistration;
    private final List<Product> shoppingCart = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, int yearRegistration) {
        this.name = name;
        this.yearRegistration = yearRegistration;
    }

    public String getName() {
        return name;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public String getClient() {
        return "Client{" +
                "name='" + name + '\'' +
                ", yearRegistration=" + yearRegistration +
                '}';
    }

    public String getClientAndShoppingCart() {
        return "Client{" +
                getShoppingCartToString() + '\'' +
                "name='" + name + '\'' +
                ", yearRegistration=" + yearRegistration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getName(), client.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public void removeAllProductsFromShoppingCart() {
        shoppingCart.clear();
    }

    public void addProductToShoppingCart(Product product) {
        shoppingCart.add(product);
    }

    public void removeProductFromShoppingCart(String type) {
        shoppingCart.removeIf(product -> product.getType().equals(type));

//        Iterator<Product> iterator = shoppingCart.iterator();
//        while (iterator.hasNext()) {
//            Product product = iterator.next();
//            if (product.getType().equals(type)) {
//                iterator.remove();
//            }
//        }
    }

    public String getShoppingCartToString() {
        String result = "";

        for(Product product : shoppingCart) {
            result = result + product.toString() + "\n";
        }

        return result;
    }

    public float getTotalPrice() {
        float sum = 0;
        for(Product product : shoppingCart) {
            sum += product.getPrice();
        }

        if (this.yearRegistration < 2018)
            return (float) (sum * 0.9);
        else
            return sum;
    }
}
