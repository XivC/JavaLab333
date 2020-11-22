package ru.ifmo.interfaces;
import ru.ifmo.entities.Entity;
import ru.ifmo.enviroments.Place;
public interface IHumanoid {
    void sit();
    void stay();
    void sleep();
    void wakeup();
    void wakeup(Entity e);
    void goTo(Place e);
    void goTo(Entity e);
    void look(Entity e);
}
