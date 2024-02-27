package main.Controller;

import main.Modell.Vehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    private CarController carController;

    public TimerListener(CarController carController) {
        this.carController = carController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : carController.cars) {
            car.move();
            carController.frame.drawPanel.moveIt(car.getX(), car.getY(), car.getModelName());
        }
    }
}
