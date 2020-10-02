package test;

import test.dto.Food;
import test.enums.FoodType;

public interface Animal {
    void voice();

    boolean eat(Food food);

    boolean isHungry();

    void setIsHungry(boolean isHungry);

    FoodType getFoodType();
}
