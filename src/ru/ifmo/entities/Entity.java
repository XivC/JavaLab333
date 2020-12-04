package ru.ifmo.entities;

public class Entity {
    public static class NameError extends Exception{
        public NameError(){
            super("Невозможно создать безымянную сущность");
        }
    }
    public final String name;
    public Entity(){
        this.name = "unnamed";
    }
    public Entity(String n) throws Exception {
        if(n.equals("")) {throw new Entity.NameError();}
        this.name = n;
    }

}
