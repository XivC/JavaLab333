package ru.ifmo.entities.items;

public class Cilindr extends Item {
    public final int width;
    public final int height;
    public Cilindr(String name, int w, int h) throws Exception{
        super(name);
        this.width = w;
        this.height = h;
    }
}
