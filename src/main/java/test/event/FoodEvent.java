package test.event;

import org.springframework.context.ApplicationEvent;
import test.Animal;

public class FoodEvent extends ApplicationEvent {

    private Animal animal;

    public FoodEvent(Object source, Animal animal) {
        super(source);
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
