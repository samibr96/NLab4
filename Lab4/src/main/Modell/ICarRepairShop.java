package main.Modell;

import main.Modell.Vehicle;

import java.util.List;

public interface ICarRepairShop<T extends Vehicle> {


    void carload(T car);

    void carUnload(T car);

    List<T> getCars();
}
