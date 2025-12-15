package com.mycompany.astonlearning;

public class AstonLearning {

    public static void main(String[] args) {
        Products[] productsArray = new Products[5];

        productsArray[0] = new Products("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 105000, true);
        productsArray[1] = new Products("PlayStation 5", "01.05.2025", "Sony", "Japan", 53099, false);
        productsArray[2] = new Products("TWS Lenovo ThinkPlus XT80", "28.03.2025", "Lenovo", "China", 1650, false);
        productsArray[3] = new Products("Apple MacBook Air 13.3", "25.04.2024", "Apple", "USA", 69799, true);
        productsArray[4] = new Products("Edifier S351DB", "04.11.2025", "Edifier", "China", 39990, false);

    }
}

