package main.Controller;

import main.Modell.Movable;

public interface IComposite extends Movable
{
    public void gas(float amount);
    public void brake(float amount);
}
