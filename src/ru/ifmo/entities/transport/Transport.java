package ru.ifmo.entities.transport;
import ru.ifmo.entities.Entity;
import ru.ifmo.enviroments.Place;

abstract public class Transport extends Entity{


    public Transport(String name) throws Exception {
        super("[Транспорт] " + name);

    }

    abstract public float getSpeed();
    abstract public void goTo(Place e);
    abstract public void stop();

}
