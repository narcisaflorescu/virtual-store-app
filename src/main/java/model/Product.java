package model;

public class Product {
    private final String type;
    private float price;
    private int stock;
    private String producer;
    public Product (String type, int stock) {
        this.type = type;
        this.stock = stock;
    }

    public Product(String type, float price, String producer) {
        this.type = type;
        this.price = price;
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  "price=" + price +
                ", producer='" + producer + ", ";
    }
}
