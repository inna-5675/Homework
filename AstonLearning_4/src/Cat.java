public class Cat extends Animal {
    private static final int maxSwimDistance = 0;
    private static final int maxRunDistance = 200;
    private Boolean satiety;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void swim(int swimDistance) {
        System.out.println("Кот " + name + " плавать не умеет.");
    }

    @Override
    public void run(int runDistance) {
        if (runDistance <= maxRunDistance) {
            System.out.println("Кот " + name + " пробежал " + runDistance + " m.");
        } else {
            System.out.println("Кот " + name + " не может пробежать " + runDistance + " m.\n" + "Максимальная дистанция = " + maxRunDistance + "м.");
        }
    }

    public void eat(Plate plate){
        if (plate.getAmountOfFood() > 0) {
            this.satiety = true;
            plate.decreaseFood(plate.getFoodPerCat());
            System.out.println(name + " покушал.");
        } else {
            System.out.println(name + " не нашел еды в миске.");
        }
    }
    public boolean isFull() {
        return satiety;
    }
}