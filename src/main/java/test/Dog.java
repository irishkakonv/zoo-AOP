package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.enums.FoodType;

@Component
public class Dog implements Animal {
    private boolean isHungry = true;
    private FoodType foodType = FoodType.ROW_MEAT;

    public void voice() {
        System.out.println("gav");
    }

    @Override
    public boolean eat(Food food) {
        isHungry = false;
        return isHungry();
    }

    @Override
    public boolean isHungry() {
        return isHungry;
    }

    @Override
    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }
}
