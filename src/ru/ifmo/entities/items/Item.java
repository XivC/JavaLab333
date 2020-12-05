package ru.ifmo.entities.items;

import ru.ifmo.entities.Entity;

public class Item extends Entity {
    public enum Status{
        BUSY,
        FREE
    }
    public static class ItemBusyError extends RuntimeException{
        public ItemBusyError(){
            super("Предмет занят");
        }
    }
    public static class ItemFreeError extends RuntimeException{
        public ItemFreeError(){
            super("Предмет не надет");
        }
    }
    private Status status;
    public Item(String name) throws Exception {
        super("[Предмет] " + name);
        status = Status.FREE;
    }
    public Status getStatus(){
        return this.status;
    }
    public void changeStatus(Status s){
        this.status = s;
    }
    public void wear() throws ItemBusyError{
        if (this.status == Status.BUSY){
            throw new ItemBusyError();
        } else this.status = Status.BUSY;
    }
    public void unwear() throws ItemFreeError{
        if (this.status == Status.FREE){
            throw new ItemFreeError();
        } else this.status = Status.FREE;
    }
}
