package ua.hillel.stolitnii.homeworks.homework3.inheritance;
import ua.hillel.stolitnii.homeworks.homework3.inheritance.Cat;
import ua.hillel.stolitnii.homeworks.homework3.inheritance.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        cat1.run(150);
        cat1.swim(5);

        cat2.run(190);
        cat2.swim(0);

        dog1.run(300);
        dog1.swim(8);

        dog2.run(180);
        dog2.swim(10);

        System.out.println("Кількість створених котів: " + Cat.getCatCount());
        System.out.println("Кількість створених собак: " + Dog.getDogCount());
        System.out.println("Загальна кількість тварин: " + Animal.getAnimalCount());
    }
}

