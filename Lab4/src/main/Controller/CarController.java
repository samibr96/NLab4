package main.Controller;

import main.Modell.Vehicle;
import main.View.CarView;

import java.util.ArrayList;

public class CarController {

    public CarView frame;
    public ArrayList<Vehicle> cars = new ArrayList<>();
    Composite composite;

    public CarController() {
        composite = new Composite(cars);
    }

    void gas(int amount) {
        composite.gas(amount);
    }

    void brake(int amount) {
        composite.brake(amount);
    }

    void turboOn() {
        composite.turboOn();
    }

    void turboOff() {
        composite.turboOff();
    }

    void liftBed() {
        composite.liftBed();
    }

    void lowerBed() {
        composite.lowerBed();
    }

}
