package Decorator.Auto;

public class AirCondition extends Decorator {
    public AirCondition(Car car) {
        super(car);
    }

    public int getPrice() {
        return this.car.getPrice() + 1500;
    }
}
