package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Cat;
import test.Cow;
import test.Dog;
import test.event.EventPublisherService;
import test.event.FoodEvent;


@Service
public class AnimalsServiceImpl implements AnimalsService {

    private final Cat cat;
    private final Dog dog;
    private final Cow cow;
    private final EventPublisherService publisherService;

    @Autowired
    public AnimalsServiceImpl(Cat cat, Dog dog, Cow cow, EventPublisherService publisherService) {
        this.cat = cat;
        this.dog = dog;
        this.cow = cow;
        this.publisherService = publisherService;
    }

    @Override
    public void startAngryVoices() throws InterruptedException {
        cat.setIsHungry(true);
        dog.setIsHungry(true);
        cow.setIsHungry(true);
        while (cat.isHungry() || dog.isHungry() || cow.isHungry()) {
            if (cat.isHungry()) {
                cat.voice();
                publisherService.publishFoodEvent(new FoodEvent(this, cat));
            }
            if (dog.isHungry()) {
                dog.voice();
                publisherService.publishFoodEvent(new FoodEvent(this, dog));
            }
            if (cow.isHungry()) {
                cow.voice();
                publisherService.publishFoodEvent(new FoodEvent(this, cow));
            }
            Thread.sleep(10000L);
        }
    }
}
