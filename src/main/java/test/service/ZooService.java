package test.service;

import test.Animal;
import test.dto.Food;

public interface ZooService {
    void feed(Food food);

    void feetAnimal(Animal animal);
}
