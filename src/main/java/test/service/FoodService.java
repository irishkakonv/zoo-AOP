package test.service;

import test.dto.Food;

import java.util.List;

public interface FoodService {
    void createFood();

    List<Food> getFoodContainer();
}
