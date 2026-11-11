import java.awt.*;

//Saab95 inherits from Car
public class Saab95 extends Car {

    private boolean turboOn;

    //Constructor
    public Saab95() {

        //Set the car information
        super(2,125,Color.RED, "Saab95");
        turboOn = false;
    }

    //Turn turbo on
    public void setTurboOn() {
        turboOn = true;
    }

    //Turn turbo off
    public void setTurboOff() {
        turboOn = false;
    }

    //Calculation and override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
