import java.awt.*;

public abstract class Car implements Movable {

    // Common attributes shared by all cars
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    // to caclute the movement
    private double x = 0;
    private double y = 0;
    private int direction = 0;
    private int upp = 0;
    private int right = 1;
    private int down = 2;
    private int left = 3;

    public void turnRight() {
        if (direction == 0) {
            direction = 1;
        } else if (direction == 1) {
            direction = 2;
        } else if (direction == 2) {
            direction = 3;
        } else {
            direction = 0;
        }
    }


    public void turnLeft() {
        if (direction == 3) {
            direction = 2;
        } else if (direction == 2) {
            direction = 1;
        } else if (direction == 1) {
            direction = 0;
        } else {
            direction = 3;
        }
    }

    public void move(){
        if (direction == 0) {
            this.y = y - currentSpeed;
        } else if (direction == 1) {
            this.x = x + currentSpeed;
        } else if (direction == 2){
            this.y = y + currentSpeed;
        } else if (direction  == 3) {
            this.x = x - currentSpeed;

        }

    }

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

    public void decrementSpeed(double amount) {
        currentSpeed = currentSpeed - speedFactor() * amount;
    }

    public void gas(double amount) {
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }

}
