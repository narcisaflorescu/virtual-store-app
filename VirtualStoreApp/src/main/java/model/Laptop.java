package model;

public class Laptop extends Product{
    private int numberProcessors;
    private boolean hasTouchscreen;

    public Laptop(String type, int stock) {
        super(type, stock);
    }

    public Laptop(String type, float price, String producer, int numberProcessors, boolean hasTouchscreen) {
        super(type, price, producer);
        this.numberProcessors = numberProcessors;
        this.hasTouchscreen = hasTouchscreen;
    }

    @Override
    public String toString() {
        return "Laptop{" + super.toString() +
                "numberProcessors=" + numberProcessors +
                ", hasTouchscreen=" + hasTouchscreen +
                '}';
    }
}
