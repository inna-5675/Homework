//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Characteristic circle = new Circle(5, "Красный", "Черный");
        Characteristic rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Characteristic triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");
        System.out.println("Характеристики круга:");
        circle.printCharacteristic();
        System.out.println();
        System.out.println("Характеристики прямоугольника:");
        rectangle.printCharacteristic();
        System.out.println();
        System.out.println("Характеристики треугольника:");
        triangle.printCharacteristic();
    }
}