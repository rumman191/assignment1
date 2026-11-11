import java.awt.*;

// Volvo240 inherits from Car
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    //Contructor
    public Volvo240() {

       //Set the car information
        super(4, 100,Color.black, "Volvo240");
    }
    
    //Calculation and override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
