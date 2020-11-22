package ru.ifmo.entities;
import ru.ifmo.entities.transport.Transport;
import ru.ifmo.enviroments.Place;
import ru.ifmo.interfaces.IHumanoid;

public class Person extends Entity implements IHumanoid {
    private Item[] items = new Item[100];

    public enum Status{
        SLEEPING,
        STAYING,
        SITTING,
        WALKING,
        LOOKING,
        CHILLING

    }

    private Status status;
    private Transport transport;
    public Person(String name){
        super("[Человек] " + name);
        this.status = Status.STAYING;
        this.transport = null;

    }
    public void sleep(){
        status = Status.SLEEPING;
        System.out.println(this.name + " засыпает");

    };
    public void wakeup(){

        if(this.status != Status.SLEEPING) {
            throw new RuntimeException(this.name + "не спит");
        }
        else {
            status = Status.CHILLING;
            System.out.println(this.name + " просыпается");
        }
    }
    public void wakeup(Entity e){
        if(this.status != Status.SLEEPING) {
            throw new RuntimeException(this.name + "не спит");
        }
        else {
            status = Status.STAYING;
            System.out.println(e.name + " разбудил " + this.name);
        }
    }
    public void goTo(Entity e){
        status = Status.WALKING;
        System.out.println(this.name + " пошёл к " + e.name);
    }
    public void goTo(Place e){
        status = Status.WALKING;
        System.out.println(this.name + " пошёл к " + e.name);
    }

    public void look(Entity e){
        status = Status.LOOKING;
        System.out.println(this.name + " смотрит на " + e.name);
    }
    public void tell(Entity e, String text){

        System.out.println(this.name + " сказал " + e.name + ":" + text);
    }
    public void tell(String text){

        System.out.println(this.name +  " сказал: " + text);
    }
    public void stay(){
        status = Status.STAYING;
        System.out.println(this.name + " стоит");
    }
    public void sit(){
        status = Status.SITTING;
        System.out.println(this.name + " присел");
    }
    public void wear(Item i){
        if(i.getStatus() == Item.Status.BUSY){
            throw new RuntimeException("Предмет занят");
        }
        else{
            for(int a = 0; a < 100; a++ ){
                if (this.items[a] == null) {
                    items[a] = i;
                    i.changeStatus(Item.Status.BUSY);
                    System.out.println(this.name + " надел " + i.name);
                    return;
                }
            }
            throw new RuntimeException("Инвентарь полон");
        }
    }
    public void unwear(Item i){
        for(int a = 0; a < 100; a++ ) {
            if(this.items[a] == i){
                this.items[a] = null;
                i.changeStatus(Item.Status.FREE);
                System.out.println(this.name + " снял " + i.name);
                return;
        }
            throw new RuntimeException("Предмет не найден");
        }
    }
    public Transport getTransport(){
        return this.transport;
    }
    public void sitTransport(Transport t){
        if (this.transport != null) {
            throw new RuntimeException(this.name + " уже находится в транспорте");
        }
        else{
            this.transport = t;
            System.out.println(this.name + " сел в " + t.name);
        }
    }
    public void leaveTransport(){
        if (this.transport == null){
            throw new RuntimeException(this.name + " не находится в транспорте");
        }
        else{
            System.out.println(this.name + " вышел из " + this.transport.name);
            this.transport = null;
        }

    }
    public Item[] getItems(){
        return items;
    }




}

