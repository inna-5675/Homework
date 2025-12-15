package com.mycompany.astonlearning;
import java.util.Date;

public class Products {
    private String productName;
    private String productionDate;
    private String productManufacturer;
    private String productCountry;
    private int productPrice;
    private Boolean isTheProductBooked;
    public Products (String productName, String productionDate, String productManufacturer, String productCountry, int productPrice, Boolean isTheProductBooked) {
        this.productName = productName;
        this.productionDate = productionDate;
        this.productManufacturer = productManufacturer;
        this.productCountry = productCountry;
        this.productPrice = productPrice;
        this.isTheProductBooked = isTheProductBooked;
    }
    public void infoOfProduct() {
        System.out.println("Название товара: "+ productName + "; Дата производства: "+ productionDate + "; Производитель: " + productManufacturer+ "; Страна производства: " +productCountry+ "; Цена: " + productPrice+ "; Состояние бронирования покупателем: " + isTheProductBooked+ ".") ;
    }

}

