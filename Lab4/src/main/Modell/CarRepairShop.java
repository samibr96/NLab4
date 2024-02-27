package main.Modell;

import java.util.ArrayList;
import java.util.List;

public class CarRepairShop<T extends Vehicle> implements ICarRepairShop<T> {

    private List<T> cars;
    private double x;
    private double y;
    private int maxNrOfCas;

    public CarRepairShop(int maxAmountOfCars, double x, double y) {
        cars = new ArrayList<>();
        this.maxNrOfCas = maxAmountOfCars;
        this.x = x;
        this.y = y;
    }

    public boolean isWorkShopFull() {
        return cars.size() >= maxNrOfCas;
    }

    @Override
    public void carload(T car) {
        if (cars.size() < maxNrOfCas) {
            cars.add(car);
        }
    }

    @Override
    public void carUnload(T car) {
        cars.remove(car);
    }

    @Override
    public List<T> getCars() {
        return cars;
    }
}
