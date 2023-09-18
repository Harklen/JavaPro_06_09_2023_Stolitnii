package ua.hillel.stolitnii.trainings.someshit;
interface Communication {
    default void call() {
        System.out.println("Дзинь-дзинь");}
    default void sendEmail() {
        System.out.println("Відправляємо");}
}


class phone implements Communication {
    @Override
    public void sendEmail() {
        System.out.println("В тебе кнопочна хуйня, ти не можеш відправити листа");
    }
}

class notebook implements Communication {
    @Override
    public void call(){
        System.out.println("Ти не можеш звонити, в тебе ноут дурень");
    }
}

public class Main {
    phone phone = new phone();
    notebook notebook = new notebook();

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Намагаємось позвонити з телефону:");
        main.phone.call();
        System.out.println("Намагаємось відправити лист з телефону:");
        main.phone.sendEmail();
        System.out.println("Намагаємось позвонити з ноутбуку:");
        main.notebook.call();
        System.out.println("Намагаємось відправити лист з ноутбуку:");
        main.notebook.sendEmail();
    }
}