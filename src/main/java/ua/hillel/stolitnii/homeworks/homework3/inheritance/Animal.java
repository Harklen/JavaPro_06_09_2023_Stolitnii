package ua.hillel.stolitnii.homeworks.homework3.inheritance;

class Animal {
    private static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println("Тварина пробігла " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Тварина пропливла " + distance + " м.");
    }
}