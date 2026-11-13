import java.awt.*;

public abstract class Car implements Movable {

    // Common attributes shared by all cars
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    // to calculate the movement
    private double x = 0;
    private double y = 0;
    private Direction direction = Direction.NORTH;

    //Constructor to initialize Car properties
    protected Car(int nrDoors, Color color,double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
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

    public String getModelName() {
        return modelName;
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


    @Override
    public void move() {
        switch (direction) {
            case NORTH:
                y += currentSpeed;
                break;
            case EAST:
                x += currentSpeed;
                break;
            case SOUTH:
                y -= currentSpeed;
                break;
            case WEST:
                x -= currentSpeed;
                break;
        }
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }


    @Override
    public void turnRight() {
        direction = switch (direction) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
        };
    }


    @Override
    public void turnLeft() {
        direction = switch (direction) {
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST -> Direction.NORTH;
        };
    }


    public Direction getDirection() {
        return direction;
    }


    // Overriden by each subclass.
    public abstract double speedFactor();


    //Increase and decrease car speed
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getEnginePower(), getCurrentSpeed() + speedFactor() * amount);
    }
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
    }


    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            return;
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            return;
        }
        decrementSpeed(amount);
    }
}
