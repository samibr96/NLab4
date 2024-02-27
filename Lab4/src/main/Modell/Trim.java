package main.Modell;

public class Trim {

    private double trimFactor;

    public Trim(double trimFactor) {
        this.trimFactor = trimFactor;
    }

    public double getTrimFactor() {
        return trimFactor;
    }

    public double applyTrim(double speedFactor) {
        return trimFactor * speedFactor;
    }
}
