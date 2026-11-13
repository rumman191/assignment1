import java.awt.*;

// Volvo240 inherits from Car
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    //Contructor
    public Volvo240() {
        super(4, Color.black, 100,"Volvo240");
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}