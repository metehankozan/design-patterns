package structural;

public class Bridge {

    interface SteeringWheel {
        void setDirection(int direction);
    }

    class CarSteeringWheel implements SteeringWheel {
        @Override
        public void setDirection(int direction) {
            System.out.println("Car direction is set to " + direction);
        }
    }

    class BoatSteeringWheel implements SteeringWheel {
        @Override
        public void setDirection(int direction) {
            System.out.println("Boat direction is set to " + direction);
        }
    }

    abstract class Vehicle {
        SteeringWheel steeringWheel;

        abstract void move(int direction, int speed);
    }

    class Car extends Vehicle {
        public Car(SteeringWheel steeringWheel) {
            this.steeringWheel = steeringWheel;
        }

        @Override
        void move(int direction, int speed) {
            steeringWheel.setDirection(direction);
        }
    }

    class Boat extends Vehicle {
        public Boat(SteeringWheel steeringWheel) {
            this.steeringWheel = steeringWheel;
        }

        @Override
        void move(int direction, int speed) {
            steeringWheel.setDirection(direction);
        }
    }

    public void bridgeDemo() {
        Vehicle car = new Car(new CarSteeringWheel());
        car.move(20, 20);

        Vehicle boat = new Boat(new BoatSteeringWheel());
        boat.move(40, 40);
    }

    public static void main(String[] args) {
        new Bridge().bridgeDemo();
    }
}
