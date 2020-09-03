package Decorator.Auto;

public class Dealer {
    public static void main(String[] args) {
        Car myCar = new AudiA3();
        System.out.println(" Base car " + myCar.getPrice());
        myCar = new AirCondition(new Gps(myCar));
        System.out.println(" GPS, AirCond car " + myCar.getPrice());
    }
}
