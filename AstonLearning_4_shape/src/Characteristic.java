public interface Characteristic {
    double getArea();
    double getPerimeter();

    String getFillColor();
    String getBorderColor();

    default void printCharacteristic() {
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}

