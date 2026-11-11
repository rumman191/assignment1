import java.awt.*;

public abstract class Car {

    // Common attributes shared by all cars
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;


    //Constructor to initialize car properties
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    //Getters
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    //Setter
    public void setColor(Color clr) {
        color = clr;
    }

    // speed control
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }


    // Overriden by each subclass.
    public abstract double speedFactor();


    //Increase and decrease car speed
    public void incrementSpeed(double amount) {
        currentSpeed = currentSpeed + speedFactor() * amount;
    }
§
    public void decrementSpeed(double amount) {
        currentSpeed = currentSpeed - speedFactor() * amount;
    }

    public void gas(double amount) {
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }
}