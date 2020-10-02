package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;
    private final FoodService foodService;

    @Autowired
    public ZooServiceImpl(Zoo zoo,
                          FoodService foodService) {
        this.zoo = zoo;
        this.foodService = foodService;
    }

    @Override
    public void feed(Food food) {
//        List<Animal> angryAnimals = zoo.getAnimals()
//                .stream()
//                .peek(animal -> animal.eat(food))
//                .filter(Animal::isHungry)
//                .collect(Collectors.toList());
//        System.out.println(angryAnimals);
    }

    @Override
    public void feetAnimal(Animal animal) {
        List<Food> feed = foodService.getFoodContainer();
        Optional<Food> food = feed.stream().filter(f -> f.getType().equals(animal.getFoodType())).findFirst();
        if (food.isPresent()) {
            Food animalFood = food.get();
            if (LocalDateTime.now().isBefore(animalFood.getExpirationDate())) {
                animal.eat(animalFood);
                feed.remove(animalFood);
            }
        } else {
            System.out.println("The food container is empty!");
        }
    }
}
