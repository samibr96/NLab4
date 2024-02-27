package main.Controller;
import main.Modell.CarAssembler;
import main.Modell.Vehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CarButtonListeners {

    private CarController carController;

    public CarButtonListeners(CarController carController) {
        this.carController = carController;
    }

    private Vehicle makeRandomCar() {
        Random random = new Random();
        int choice = random.nextInt(3);

        double x = random.nextDouble() * 685;
        double y = random.nextDouble() * 500;

        if (choice == 0) {
            return CarAssembler.assembleVolvo(x, y);
        }
        else if (choice == 1) {
            return CarAssembler.assembleSaab(x, y);
        }
        else {
            return CarAssembler.assembleScania(x, y);
        }
    }

    public void Listeners() {

        carController.frame.addCarButton.addActionListener(new ActionListener() {
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

        carController.frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carController.cars.isEmpty()) {
                    carController.cars.remove(carController.cars.size()-1);
                    carController.frame.drawPanel.repaint();
                }
            }
        });

        carController.frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : carController.cars) {
                    car.startEngine();
                }
            }
        });

        carController.frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : carController.cars) {
                    car.stopEngine();
                }
            }
        });

        carController.frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.gas(carController.frame.gasAmount);
            }
        });

        carController.frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.brake(carController.frame.gasAmount);
            }
        });

        carController.frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOn();
            }
        });

        carController.frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOff();
            }
        });

        carController.frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.liftBed();
            }
        });

        carController.frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.lowerBed();
            }
        });
    }
}
