package model;

import java.util.Scanner;

public class Keypad {
    Scanner sc = new Scanner(System.in);

    public String getString() {
        return sc.next();
    }

    public int getInteger() {
        return sc.nextInt();
    }

    public float getFloat() {
        return sc.nextFloat();
    }

    public boolean getBoolean() {
        return sc.nextBoolean();
    }
}
