package model;

import java.util.*;

public class StoreDB {

    private final List<Client> clientList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public StoreDB()  {
        Client c1 = new Client("Andrei", 1999);
        Client c2 = new Client("Andreea", 1998);
        clientList.add(c1);
        clientList.add(c2);
        Product p1 = new Laptop("laptop", 10);
        Product p2 = new TV("tv", 2);
        Product p3 = new Phone("phone", 5);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
    }

    public String getClients() {
        StringBuilder result = new StringBuilder();
        for(Client client : clientList) {
            result.append(client.getClient()).append("\n");
        }
        return result.toString();
    }

    public String getClientAndShoppingCart() {
        clientList.sort(Comparator.comparing(Client::getName));
        StringBuilder result = new StringBuilder();
        for(Client client : clientList) {
            result.append(client.getClientAndShoppingCart()).append("\n")
                    .append("---------------------").append("\n")
                    .append("Total Price: ").append(client.getTotalPrice()).append("\n \n");
        }
        return result.toString();
    }

}
