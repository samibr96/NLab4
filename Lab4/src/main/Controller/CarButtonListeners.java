package main.Controller;
import main.Modell.CarAssembler;
import main.Modell.Vehicle;
import main.View.CarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CarButtonListeners {

    private CarController carController;

    private CarView frame;

    public CarButtonListeners(CarController carController, CarView frame) {
        this.carController = carController;
        this.frame = frame;
    }

    public void Listeners() {

        frame.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carController.cars.size() < 10) {

                    Vehicle randomCar = makeRandomCar();
                    if (randomCar != null) {
                        carController.cars.add(randomCar);
                    }
                }
            }
        });

        frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carController.cars.isEmpty()) {
                    carController.cars.remove(carController.cars.size()-1);
                    carController.frame.drawPanel.repaint();
                }
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : carController.cars) {
                    car.startEngine();
                }
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : carController.cars) {
                    car.stopEngine();
                }
            }
        });

        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.gas(frame.gasAmount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.brake(frame.gasAmount);
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOn();
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOff();
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.liftBed();
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.lowerBed();
            }
        });
    }

    private Vehicle makeRandomCar() {
        Random random = new Random();
        int carChoice = random.nextInt(3);

        double x = random.nextDouble() * 685;
        double y = random.nextDouble() * 500;

        if (carChoice == 0) {
            return CarAssembler.assembleVolvo(x, y);

        }
        else if (carChoice == 1) {
            return CarAssembler.assembleSaab(x, y);
        }
        else {
            return CarAssembler.assembleScania(x, y);
        }
    }
}
