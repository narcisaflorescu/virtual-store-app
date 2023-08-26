package model;

public class Phone extends Product{
    private float batterySize;
    private int numberMegapixels;

    public Phone(String type, float price, String producer, float batterySize, int numberMegapixels) {
        super(type, price, producer);
        this.batterySize = batterySize;
        this.numberMegapixels = numberMegapixels;
    }

    public Phone(String type, int stock) {
        super(type, stock);
    }

    @Override
    public String toString() {
        return "Phone{" + super.toString() +
                "batterySize=" + batterySize +
                ", numberMegapixels=" + numberMegapixels +
                '}';
    }
}
