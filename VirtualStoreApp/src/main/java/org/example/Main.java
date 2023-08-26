package org.example;

import exceptions.ClientExistException;
import model.*;

public class Main {



    public static void main(String[] args) throws ClientExistException {
        Store store = new Store();
        store.startActions();
    }
}