package ua.hillel.stolitnii.homeworks.homework3.inheritance;
import ua.hillel.stolitnii.homeworks.homework3.inheritance.Animal;
class Dog extends Animal {
    private static int dogCount = 0;
    private static final int maxRunDistance = 500;
    private static final int maxSwimDistance = 10;

    public Dog() {
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Собака пробігла " + distance + " м.");
        } else {
            System.out.println("Собака не може пробігти " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println("Собака пропливла " + distance + " м.");
        } else {
            System.out.println("Собака не може пропливти " + distance + " м.");
        }
    }
}
//пес