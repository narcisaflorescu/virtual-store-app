package model;

import exceptions.ClientExistException;
import exceptions.ClientNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Store {

    private final StoreDB storeDB;
    private final Keypad keypad;
    private final Screen screen;

    public Store() {
        storeDB = new StoreDB();
        keypad = new Keypad();
        screen = new Screen();
    }

    public void startActions() {
        // Creare și configurare a unui planificator de execuție
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this::displayStock, 10, 15, TimeUnit.SECONDS);

        while(true) {
            screen.showOptions();
            screen.showMessage("Enter an option from menu: ");
            int option = keypad.getInteger();

            if(!executeOption(option)) {
                executor.shutdown(); // Închide executorul
                return;
            }

        }
    }

    // Metoda pentru a afișa stocul produselor
    private void displayStock() {
        System.out.println("Stock of all products:");
        for (Product product : storeDB.getProductList()) {
            System.out.println("Product: " + product.getType() + " | Stock: " + product.getStock());
        }
        System.out.println();
    }

    private boolean executeOption(int option) throws ClientExistException {


        switch (option) {
            case 1 -> addClient();
            case 2 -> addProduct();
            case 3 -> removeProduct();
            case 4 -> removeAllProducts();
            case 5 -> System.out.println(storeDB.getClients());
            case 6 -> getShoppingCart();
            case 7 -> System.out.println(storeDB.getClientAndShoppingCart());
            case 8 -> {
                return false;
            }
            default -> System.out.println("Invalid");
        }

        return true;
    }


    private void addStock(List<Product> shoppingCart) {
        for(Product product : shoppingCart) {
            for(Product pr : storeDB.getProductList()) {
                if(pr.getType().equals(product.getType())) {
                    pr.setStock(pr.getStock() + 1);
                    break;
                }
            }
        }
    }


    private void removeAllProducts() {
        screen.showMessage("Enter client's name: ");
        String name = keypad.getString();
        Client client = new Client(name);

        try {
            if (!storeDB.getClientList().contains(client)) {
                throw new ClientNotFoundException();
            }

            for (Client cl : storeDB.getClientList()) {
                if (cl.equals(client)) {
                    cl.removeAllProductsFromShoppingCart();
                    addStock(cl.getShoppingCart());
                }
            }
        }
        catch (ClientNotFoundException e) {
            System.out.println("Client not found in DB");
        }
    }

    private void removeProduct() {
        screen.showMessage("Enter client's name: ");
        String name = keypad.getString();
        Client client = new Client(name);

        try {
            if (!storeDB.getClientList().contains(client)) {
                throw new ClientNotFoundException();
            }

            for(Client cl : storeDB.getClientList()) {
                if(cl.equals(client)) {
                    screen.showMessage("Enter type of product (phone/tv/laptop): ");
                    String type = keypad.getString();
                    cl.removeProductFromShoppingCart(type);
                    addStock(cl.getShoppingCart());
                    break;
                }
            }

        }
        catch (ClientNotFoundException e) {
            System.out.println("Client not found in DB");
        }
    }

    private void getShoppingCart() {
        screen.showMessage("Enter client's name: ");
        String name = keypad.getString();
        Client client = new Client(name);

        try {
            if (!storeDB.getClientList().contains(client)) {
                throw new ClientNotFoundException();
            }

            for(Client cl : storeDB.getClientList()) {
                if(cl.equals(client)) {
                    System.out.println(cl.getShoppingCartToString());
                    System.out.println("Total Price: " + cl.getTotalPrice());
                }
            }
        }
        catch (ClientNotFoundException e) {
            System.out.println("Client not found in DB");
        }

    }

    private void addProduct() {
        screen.showMessage("Enter client's name: ");
        String name = keypad.getString();
        Client client = new Client(name);

        try {

            if (!storeDB.getClientList().contains(client)) {
                throw new ClientNotFoundException();
            }

            for(Client cl : storeDB.getClientList()) {
                if(cl.equals(client)) {

                    screen.showMessage("Enter type of product (phone/tv/laptop): ");
                    String type = keypad.getString();
                    screen.showMessage("Enter price: ");
                    float price = keypad.getFloat();
                    screen.showMessage("Enter producer: ");
                    String producer = keypad.getString();

                    switch (type) {
                        case ("phone"): {
                            screen.showMessage("Enter batterySize: ");
                            float batterySize = keypad.getFloat();
                            screen.showMessage("Enter numberMegapixels: ");
                            int numberMegapixels = keypad.getInteger();

                            for (Product product : storeDB.getProductList()) {
                                if (product.getType().equals("phone")) {
                                    if (product.getStock() > 0) {
                                        cl.addProductToShoppingCart(new Phone("phone", price, producer, batterySize, numberMegapixels));
                                        product.setStock(product.getStock() - 1);
                                    } else
                                        System.out.println("Insufficient stock \n");

                                }
                            }
                            break;
                        }


                        case ("tv"): {
                            screen.showMessage("Enter diagonal: ");
                            float diagonal = keypad.getFloat();
                            screen.showMessage("Enter isSmart: ");
                            boolean isSmart = keypad.getBoolean();

                            for (Product product : storeDB.getProductList()) {
                                if (product.getType().equals("tv")) {
                                    if (product.getStock() > 0) {
                                        cl.addProductToShoppingCart(new TV("tv", price, producer, diagonal, isSmart));
                                        product.setStock(product.getStock() - 1);
                                    } else
                                        System.out.println("Insufficient stock \n");

                                }
                            }
                            break;
                        }

                        case ("laptop"): {
                            screen.showMessage("Enter numberProcessors: ");
                            int numberProcessors = keypad.getInteger();
                            screen.showMessage("Enter hasTouchscreen: ");
                            boolean hasTouchscreen = keypad.getBoolean();

                            for (Product product : storeDB.getProductList()) {
                                if (product.getType().equals("tv")) {
                                    if (product.getStock() > 0) {
                                        cl.addProductToShoppingCart(new Laptop("laptop", price, producer, numberProcessors, hasTouchscreen));
                                        product.setStock(product.getStock() - 1);
                                    } else
                                        System.out.println("Insufficient stock \n");

                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        catch (ClientNotFoundException e) {
            System.out.println("Client not found in DB");
        }
    }


    private void addClient() {
        try {
            screen.showMessage("Enter name: ");
            String name = keypad.getString();
            int yearRegistration = LocalDate.now().getYear();
            Client client = new Client(name, yearRegistration);

            if (!storeDB.getClientList().contains(client)) {
                storeDB.getClientList().add(client);
            } else {
                throw new ClientExistException();
            }
        } catch (ClientExistException e) {
            System.out.println("The client is already added");
        }
    }
}
