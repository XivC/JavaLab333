package ru.ifmo.entities;

public class Item extends Entity{
    public enum Status{
        BUSY,
        FREE;
    }
    private Status status;
    public Item(String name) {
        super("[Предмет] " + name);
        status = Status.FREE;
    }
    public Status getStatus(){
        return this.status;
    }
    public void changeStatus(Status s){
        this.status = s;
    }
}
