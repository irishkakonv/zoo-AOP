package test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.dto.Food;
import test.enums.FoodType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private List<Food> foodContainer = new ArrayList<>();

    @Override
    @Scheduled(fixedRate = 25000)
    @Async
    public void createFood() {
        System.out.println("Create and add food in the container");
        Food milk = new Food("Milk", LocalDateTime.now().plusMinutes(1), FoodType.MILK);
        Food meat = new Food("Row meat", LocalDateTime.now().plusMinutes(2), FoodType.ROW_MEAT);
        Food grass = new Food("Grass", LocalDateTime.now().plusMinutes(3), FoodType.GRASS);
        foodContainer.add(milk);
        foodContainer.add(meat);
        foodContainer.add(grass);
    }

    public List<Food> getFoodContainer() {
        return foodContainer;
    }
}
