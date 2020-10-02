package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.service.AnimalsService;
import test.service.ZooService;

@Service
public class EventListenerService {

    private final AnimalsService animalsService;
    private final ZooService zooService;

    @Autowired
    public EventListenerService(AnimalsService animalsService,
                                ZooService zooService) {
        this.animalsService = animalsService;
        this.zooService = zooService;
    }

    @EventListener(ZooEvent.class)
    public void onApplicationZooEvent(ZooEvent zooEvent) throws InterruptedException {
        System.out.println(zooEvent.getMessage());
        animalsService.startAngryVoices();
    }

    @EventListener(FoodEvent.class)
    public void onApplicationFoodEvent(FoodEvent foodEvent) {
        zooService.feetAnimal(foodEvent.getAnimal());
    }
}
