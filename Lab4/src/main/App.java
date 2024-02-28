package main;

import main.Controller.CarButtonListeners;
import main.Controller.CarController;
import main.View.CarView;
import main.Controller.TimerListener;
import main.Modell.CarAssembler;

import javax.swing.*;

public class App {
    private final int delay = 50;
    private Timer timer;
    private CarController carController;
    CarButtonListeners buttonListeners;

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public App() {
        carController = new CarController();
        timer = new Timer(delay, new TimerListener(carController));
    }

    public void start() {
        carController.cars.add(CarAssembler.assembleSaab(0, 100));
        carController.cars.add(CarAssembler.assembleVolvo(0, 0));
        carController.cars.add(CarAssembler.assembleScania(0, 200));

        carController.frame = new CarView("CarSim 1.0");
        buttonListeners = new CarButtonListeners(carController, carController.frame);
        buttonListeners.Listeners();

        timer.start();
    }
}
