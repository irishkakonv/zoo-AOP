package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.event.EventPublisherService;
import test.event.ZooEvent;

@Service
public class HungryAnimalsCheckerImpl implements HungryAnimalsChecker {

    private final EventPublisherService publisherService;

    @Autowired
    public HungryAnimalsCheckerImpl(EventPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    @Scheduled(fixedRate = 15000, initialDelay = 3000)
    @Async
    public void startHungryVoice() throws InterruptedException {
       publisherService.publishZooEvent(new ZooEvent(this, "Animals are hungry!"));
    }
}
