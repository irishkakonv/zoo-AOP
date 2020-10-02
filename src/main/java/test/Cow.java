package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.enums.FoodType;

@Component
public class Cow implements Animal{

    private boolean isHungry = true;
    private FoodType foodType = FoodType.GRASS;

    @Override
    public void voice() {
        System.out.println("My");
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
