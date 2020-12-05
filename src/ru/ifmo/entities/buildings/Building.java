package ru.ifmo.entities.buildings;

import ru.ifmo.entities.Entity;

public class Building extends Entity {
    public Building(String name) throws Exception {
        super("[Здание]" + name);
    }
}
