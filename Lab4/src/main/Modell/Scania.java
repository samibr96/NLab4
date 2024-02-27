package main.Modell;

import java.awt.*;

public class Scania extends Truck {

    private Platform platform;

    public Scania(Direction direction, double x, double y) {
        super("Scania", 2, 2, 0, Color.RED, direction, x, y);
        this.platform = new Platform();
    }

    public double getPlatformAngle() {
        return platform.getAngle();
    }

    public void raisePlatform(double degrees) {
        if (getCurrentSpeed() == 0) {
            platform.raise(degrees);
        }
    }

    public void lowerPlatform(double degrees) {
        if (getCurrentSpeed() == 0) {
            platform.lower(degrees);
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        if (getPlatformAngle() == 0) {
            super.move();
        }
    }
}
