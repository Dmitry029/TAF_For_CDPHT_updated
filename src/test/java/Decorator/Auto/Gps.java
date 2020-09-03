package Decorator.Auto;

public class Gps extends Decorator {
    public Gps(Car car) {
        super(car);
    }

    public int getPrice() {
        return this.car.getPrice() + 1000;
    }
}
