public class Plate {
    protected int amountOfFood;
    private int foodPerCat;
    public Plate(int foodAmount, int foodPerCat) {
        this.amountOfFood = foodAmount;
        this.foodPerCat = foodPerCat;
    }
    public int getAmountOfFood() {
        return amountOfFood;
    }
    public int getFoodPerCat() {
        return foodPerCat;
    }
    public void decreaseFood(int amount) {
        if (amount <= amountOfFood) {
            amountOfFood -= amount;
        }
    }
    public void addFood(int amount) {
        amountOfFood += amount;
        System.out.println("В миску добалено " + amount + " еды. Теперь в миске " + amountOfFood + " еды.");
    }
}

