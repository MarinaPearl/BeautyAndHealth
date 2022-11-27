package ru.Demchuck.BeautyAndHealth.Parser;

import lombok.Getter;

@Getter
public class DataBaseParametr {
    private String brand;
    private String shortDescription;
    private String volume;
    private int price;
    private String description;

    public DataBaseParametr(String brand, String shortDescription, String volume, String price, String description) {
        this.brand = brand;
        this.shortDescription = shortDescription;
        this.volume = volume;
        this.price = Integer.parseInt(price);
        this.description = description;
    }
}
