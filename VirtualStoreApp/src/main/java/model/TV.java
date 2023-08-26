package model;

public class TV extends Product{
    private float diagonal;
    private boolean isSmart;

    public TV(String type, int stock) {
        super(type, stock);
    }

    public TV(String type, float price,String producer, float diagonal, boolean isSmart) {
        super(type, price, producer);
        this.diagonal = diagonal;
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return "TV{" + super.toString() +
                "diagonal=" + diagonal +
                ", isSmart=" + isSmart +
                '}';
    }
}
