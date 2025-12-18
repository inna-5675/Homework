//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMisha = new Cat("Миша");
        Cat catMasha = new Cat("Маша");
        Cat catSasha = new Cat("Саша");
        Plate plate = new Plate(20, 10); // Миска с 20 единицами еды и 10 на кота

        Cat[] cats = {catMisha, catMasha, catSasha};
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        for (Cat cat : cats) {
            String status = cat.isFull() ? "сыт" : "голоден";
            System.out.println(cat.name + " сейчас " + status + ".");
        }

        dogBobik.run(150);
        dogBobik.swim(5);
        catMisha.run(100);
        catMisha.swim(5);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
    }
}
