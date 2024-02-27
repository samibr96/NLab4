package main.Modell;

public class CarAssembler {

    public static Vehicle assembleVolvo(double x, double y) {
        return new Volvo240(Direction.EAST, x, y);
    }

    public static Vehicle assembleSaab(double x, double y) {
        return new Saab95(Direction.EAST, x, y);
    }

    public static Vehicle assembleScania(double x, double y) {
        return new Scania(Direction.EAST, x, y);
    }

}
