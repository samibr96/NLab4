package main.Controller;

import main.Modell.Saab95;
import main.Modell.Scania;
import main.Modell.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Composite implements IComposite {

    private final List<Vehicle> cars;

    public Composite(List<Vehicle> cars) {
        this.cars = cars;
    }


    public void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatform(45);
            }
        }
    }


    public void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatform(45);
            }
        }
    }

    @Override
    public void gas(float amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    @Override
    public void brake(float amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }

    }




}
