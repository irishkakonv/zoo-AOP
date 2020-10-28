package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Animal;
import test.event.EventPublisherService;
import test.event.FoodEvent;

import java.util.List;


@Service
public class AnimalsServiceImpl implements AnimalsService {

    private final EventPublisherService publisherService;
    private final List<Animal> animalList;

    @Autowired
    public AnimalsServiceImpl(EventPublisherService publisherService, List<Animal> animalList) {
        this.publisherService = publisherService;
        this.animalList = animalList;
    }

    @Override
    public void startAngryVoices() throws InterruptedException {
        animalList.forEach(animal -> animal.setIsHungry(true));
        while (animalList.stream().anyMatch(Animal::isHungry)) {
            animalList.forEach(animal -> {
                if (animal.isHungry()) {
                    animal.voice();
                    publisherService.publishFoodEvent(new FoodEvent(this, animal));
                }
            });
            Thread.sleep(10000L);
        }
    }
}
