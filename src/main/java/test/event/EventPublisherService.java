package test.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {

    private final ApplicationEventPublisher publisher;

    public EventPublisherService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishZooEvent(ZooEvent zooEvent) {
        publisher.publishEvent(zooEvent);
    }

    public void publishFoodEvent(FoodEvent foodEvent) {
        publisher.publishEvent(foodEvent);
    }
}
