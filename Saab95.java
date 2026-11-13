import java.awt.*;

//Saab95 inherits from Car
public class Saab95 extends Car {

    private boolean turboOn;

    //Constructor
    public Saab95() {

        //Set the car information
        super(2,Color.red, 125,"Saab95" );
        turboOn = false;
        stopEngine();
    }

    //Turn turbo on
    public void setTurboOn() {
        turboOn = true;
    }

    //Turn turbo off
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
