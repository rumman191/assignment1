public class CarTest {
    private static void reportResult(String testName, boolean success) {
        System.out.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void testSaabMoveNorth() {
        Saab95 saab = new Saab95();
        saab.gas(0.5);
        double speed = saab.getCurrentSpeed();
        saab.move();
        double newY = saab.getY();
        boolean result = newY == speed;
        reportResult("Saab Move North", result);
    }

    private static void testMoveNorth() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
        double speed = volvo.getCurrentSpeed();
        volvo.move();
        double newY = volvo.getY();
        boolean result = newY == speed;
        reportResult("Move North", result);
    }

    private static void testMoveSouth() {
        Volvo240 volvo = new Volvo240();
        volvo.turnRight();
        volvo.turnRight();
        volvo.gas(0.5);
        double speed = volvo.getCurrentSpeed();
        volvo.move();
        double newY = volvo.getY();
        boolean result = newY == -speed;
        reportResult("Move South", result);
    }

    private static void testMoveEast() {
        Volvo240 volvo = new Volvo240();
        volvo.turnRight();
        volvo.gas(0.5);
        double speed = volvo.getCurrentSpeed();
        volvo.move();
        double newX = volvo.getX();
        boolean result = newX == speed;
        reportResult("Move East", result);
    }

    private static void testMoveWest() {
        Volvo240 volvo = new Volvo240();
        volvo.turnLeft();
        volvo.gas(0.5);
        double speed = volvo.getCurrentSpeed();
        volvo.move();
        double newX = volvo.getX();
        boolean result = newX == -speed;
        reportResult("Move West", result);
    }


    private static void testTurnRight() {
        Volvo240 volvo = new Volvo240();
        volvo.turnRight();
        boolean result = volvo.getDirection() == Direction.EAST;
        reportResult("turnRight", result);
    }

    private static void testTurnLeft() {
        Volvo240 volvo = new Volvo240();
        volvo.turnLeft();
        boolean result = volvo.getDirection() == Direction.WEST;
        reportResult("turnLeft", result);
    }

    private static void testStartEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        double speed = volvo.getCurrentSpeed();
        boolean result = speed == 0.1;
        reportResult("Start Engine", result);
    }

    private static void testStopEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.stopEngine();
        double speed = volvo.getCurrentSpeed();
        boolean result = speed == 0;
        reportResult("Stop Engine", result);
    }

    private static void testGas() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
        double speed = volvo.getCurrentSpeed();
        boolean result = speed > 0;
        reportResult("Gas increases speed", result);
    }

    private static void testInvalidGas() {
        Volvo240 volvo = new Volvo240();
        double speed = volvo.getCurrentSpeed();
        volvo.gas(1.5);
        double new1speed = volvo.getCurrentSpeed();
        boolean result = new1speed == speed;
        reportResult("Invalid Gas does not change car's speed", result);
    }

    private static void testBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
        double speed = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        double newSpeed = volvo.getCurrentSpeed();
        boolean result = newSpeed < speed;
        reportResult("Brake decreases speed", result);
    }

    private static void testInvalidBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(1);
        double speed = volvo.getCurrentSpeed();
        volvo.brake(1.5);
        double new2Speed = volvo.getCurrentSpeed();
        boolean result = new2Speed == speed;
        reportResult("Invalid Brake does not change car's speed", result);
    }

    private static void testMinimumSpeed() {
        Saab95 saab = new Saab95();
        saab.gas(0.1);
        saab.brake(1);
        double speed = saab.getCurrentSpeed();
        boolean result = speed >= 0;
        reportResult("Speed never below zero", result);
    }

    private static void testMaximumSpeed() {
        Volvo240 volvo = new Volvo240();
        for (int i = 0; i < 100; i++) {
            volvo.gas(1);
        }
        double speed = volvo.getCurrentSpeed();
        boolean result = speed <= 100;
        reportResult("Speed never exceeds enginePower", result);
    }

    private static void testGasNeverDecreasesSpeed() {
        Saab95 saab = new Saab95();
        double speed = saab.getCurrentSpeed();
        saab.gas(0.5);
        double speed_new = saab.getCurrentSpeed();
        boolean result = speed_new >= speed;
        reportResult("Gas cannot decrease speed", result);
    }

    private static void testBrakeNeverIncreasesSpeed() {
        Saab95 saab = new Saab95();
        saab.gas(0.5);
        double speed = saab.getCurrentSpeed();
        saab.brake(0.5);
        double speed_1new = saab.getCurrentSpeed();
        boolean result = speed_1new <= speed;
        reportResult("Brake cannot increase speed", result);
    }


    public static void main(String[] args) {
        testTurbo();
        testMoveNorth();
        testTurnRight();
        testTurnLeft();
        testMoveSouth();
        testMoveEast();
        testMoveWest();
        testStartEngine();
        testStopEngine();
        testGas();
        testBrake();
        testSaabMoveNorth();
        testInvalidGas();
        testInvalidBrake();
        testMinimumSpeed();
        testMaximumSpeed();
        testGasNeverDecreasesSpeed();
        testBrakeNeverIncreasesSpeed();
        //TODO: add and run more tests
    }
}
