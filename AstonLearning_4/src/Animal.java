public class Animal {
    protected String name;
    protected static int animalCount = 0;
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void swim(int swimDistance) {
        System.out.println("Какое-то животное плывет");
    }
    public void run(int runDistance) {
        System.out.println("Какое-то животное бежит");
    }
    public static int getAnimalCount() {
        return animalCount;
    }
}

