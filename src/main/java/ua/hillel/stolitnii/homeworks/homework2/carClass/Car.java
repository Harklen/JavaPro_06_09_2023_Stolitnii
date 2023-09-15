package ua.hillel.stolitnii.homeworks.homework2.carClass;

public class Car {

        public void start() {
            startElectricity();
            startCommand();
            startFuelSystem();
        }

        private void startElectricity() {
            System.out.println("Starting electricity system");
        }

        private void startCommand() {
            System.out.println("Starting command system");
        }

        private void startFuelSystem() {
            System.out.println("Starting fuel system");
        }

        public static void main(String[] args) {
            Car car = new Car();
            car.start();
        }
    }
