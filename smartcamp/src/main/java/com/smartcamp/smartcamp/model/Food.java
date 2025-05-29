package com.smartcamp.smartcamp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food_item")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(nullable = false)
    private Double price;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    // Constructors
    public Food() {
    }

    public Food(Long foodId, String foodName, Double price, String shopName) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.shopName = shopName;
    }

    // Getters and Setters
    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
