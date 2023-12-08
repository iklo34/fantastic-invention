import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ElectronicDevice> devices = new ArrayList<>();
        devices.add(new Television());
        devices.add(new Computer());

        for (ElectronicDevice device : devices) {
            // Downcasting
            if (device instanceof Television) {
                //я так розумію що не обов'язково писати оце
                //Television t1 = (Television) device;
                //t1.showCartoons();
                //а можна зробити так ((Television) device).showCartoons();?
                device.turnOn();
                ((Television) device).showCartoons();
                device.turnOff();
            }
        }
        System.out.println();
        for (ElectronicDevice device : devices){
                if (device instanceof Computer){
                    device.turnOn();
                    device.turnOff();
                }
            }
        System.out.println();

        //------------------------------------------------------------------

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Motorcycle());
        vehicles.add(new Car());

        for (Vehicle vehic : vehicles){
            if (vehic instanceof Car){
                vehic.start();
                ((Car) vehic).Drive();
                vehic.stop();
            }
            System.out.println();
        }
        for (Vehicle vehic : vehicles){
            if (vehic instanceof Motorcycle){
                vehic.start();
                ((Motorcycle) vehic).DriveOnOneWheel();
                vehic.stop();
            }
        }
        System.out.println();
        //-------------------------------------------------------------
        List<Dish> dishes =new ArrayList<>();
        dishes.add(new Soup());
        dishes.add(new Steak());

        for (Dish dish : dishes){
            if (dish instanceof Soup){
                dish.cook();
            }
        }
        System.out.println();
        for (Dish dish : dishes){
            if (dish instanceof Steak){
                dish.cook();
            }
        }
    }
}
interface ElectronicDevice {
    void turnOn();
    void turnOff();
}

class Television implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Television turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Television turned off");
    }
    public void showCartoons(){
        System.out.println("Showing cartoons");
    }
}

class Computer implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Computer turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Computer turned off");
    }
}

interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
    public void Drive(){
        System.out.println("I drive");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }
    public void DriveOnOneWheel(){
        System.out.println("Driving on one wheel");
    }
}
interface Dish {
    void cook();
}

class Soup implements Dish {
    @Override
    public void cook() {
        System.out.println("Soup is cooked");
    }
}

class Steak implements Dish {
    @Override
    public void cook() {
        System.out.println("Steak is cooked");
    }
}
