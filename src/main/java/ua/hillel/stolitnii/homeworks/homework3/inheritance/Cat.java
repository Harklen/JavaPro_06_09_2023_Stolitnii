package ua.hillel.stolitnii.homeworks.homework3.inheritance;
import ua.hillel.stolitnii.homeworks.homework3.inheritance.Animal;
class Cat extends Animal {
    private static int catCount = 0;
    private static final int maxRunDistance = 200;

    public Cat() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Кіт пробіг " + distance + " м.");
        } else {
            System.out.println("Кіт не може пробігти " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кіт не вміє плавати.");
    }
}
//кіт