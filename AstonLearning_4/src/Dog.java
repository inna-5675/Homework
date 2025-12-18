public class Dog extends Animal{
    private static final int maxSwimDistance = 10;
    private static final int maxRunDistance = 500;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance <= maxSwimDistance) {
            System.out.println("Собака " + name + " проплыла " + swimDistance + " m.");
        } else {
            System.out.println("Собака " + name + " не может проплыть " + swimDistance + " m.\n" + "Максимальная дистанция = " + maxSwimDistance + "м.");
        }
    }

    @Override
    public void run(int runDistance) {
        if (runDistance <= maxRunDistance) {
            System.out.println("Собака " + name + " пробежал " + runDistance + " m.");
        } else {
            System.out.println("Собака " + name + " не может пробежать " + runDistance + " m.\n" + "Максимальная дистанция = " + maxRunDistance + "м.");
        }
    }
}
