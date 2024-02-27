package main.Modell;

public class Platform {

    private double angle;

    public Platform() {
        this.angle = 0;
    }

    public double getAngle() {
        return angle;
    }

    public void raise(double degrees) {
        angle = Math.min(angle + degrees, 70);
    }

    public void lower(double degrees) {
        angle = Math.max(angle - degrees, 0);
    }
}
