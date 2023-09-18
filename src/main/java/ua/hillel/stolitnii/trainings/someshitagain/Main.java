package ua.hillel.stolitnii.trainings.someshitagain;
//Робимо інтерфейс в якому лежать всі види сиру
interface Сheese {
    default void chedder() {
        System.out.println("Chedder");
    }
    default void parmesan() {
        System.out.println("Parmesan");
    }
    default void mozzarella() {
        System.out.println("Mozzarella");
    }

    default void dorblue(){
        System.out.println("Dorblue");
    }
}
//робимо абстрактне понятт піца
abstract class Pizza {
    abstract void filling();
    abstract void sauce();
    abstract void cheese();
    abstract void dough();
    abstract void bake();
}
//імплементуємо дефолтне виконання піци
class BlankPizza extends Pizza {

    @Override
    void dough(){
        System.out.println("Тонке");
    }
    @Override
    void sauce(){
        System.out.println("Томатна");
    }
    @Override
    void cheese(){
        System.out.println("Моцарелла");
    }
    @Override
    void filling(){
        System.out.println("Шинка");
    }
    @Override
    void bake(){
        System.out.println("В духовці");
    }
}
//робимо піцу з 4 сирів на основі дефолтого виконання і інтерфейсу
class FourCheeses extends BlankPizza implements Сheese {
    @Override
    void cheese(){
    }
    @Override
    void sauce(){
        System.out.println("Сметанний соус");
    }
}
class Margarita extends BlankPizza {
    @Override
    void filling(){
        System.out.println("Салямі");
    }
}

//паралельно використовуємо сир в пасті
class Pasta implements Сheese {
    void pasta(){
        System.out.println("Паста");
    }

}
public class Main {
    public static void main(String[] args) {

        System.out.println("Сьогодні в меню:");
        System.out.println("Піца 4 сири:");
        FourCheeses fourCheeses = new FourCheeses();
        fourCheeses.dough();
        fourCheeses.sauce();
        fourCheeses.mozzarella();
        fourCheeses.chedder();
        fourCheeses.parmesan();
        fourCheeses.dorblue();
        fourCheeses.filling();
        fourCheeses.bake();
        System.out.println("Піца Маргарита:");
        Margarita margarita = new Margarita();
        margarita.dough();
        margarita.sauce();
        margarita.cheese();
        margarita.filling();
        margarita.bake();
        System.out.println("Паста:");
        Pasta pasta = new Pasta();
        pasta.pasta();
        pasta.mozzarella();
        pasta.parmesan();
    }
}
