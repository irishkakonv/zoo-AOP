package test.dto;

import test.enums.FoodType;

import java.time.LocalDateTime;

public class Food {
    private String foodName;
    private LocalDateTime expirationDate;
    private FoodType type;

    public Food() {
    }

    public Food(String foodName, LocalDateTime expirationDate, FoodType type) {
        this.foodName = foodName;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    public String getFoodName() {
        return foodName;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public FoodType getType() {
        return type;
    }
}
