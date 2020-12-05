package ru.ifmo.entities.humanoids;
import ru.ifmo.entities.Entity;
import ru.ifmo.entities.items.Item;
import ru.ifmo.entities.transport.Transport;
import ru.ifmo.enviroments.Place;
import ru.ifmo.interfaces.IHumanoid;
import ru.ifmo.interfaces.IRead;
import ru.ifmo.interfaces.IThink;
public class Person extends Entity implements IHumanoid, IRead, IThink {

    public static class InventoryFullError extends RuntimeException{
        public InventoryFullError(){
            super("Инвентарь полон");
        }
    }
    public static class ItemNotFoundError extends RuntimeException{
        public ItemNotFoundError(){
            super("предмет не найден");
        }
    }
    public static class TransportError extends RuntimeException{
        public TransportError(String name){
            super(name + " уже находится в транспорте");
        }
    }
    public static class NoTransportError extends RuntimeException{
        public NoTransportError (String name){
            super(name + " не находится в транспорте");
        }
    }
    public static class NoSleepError extends RuntimeException {
        public NoSleepError(String name) {
            super(name + " не спит");
        }
    }


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
    public Person(String name) throws Exception {
        super("[Человек] " + name);
        this.status = Status.STAYING;
        this.transport = null;

    }
    public void sleep(){
        status = Status.SLEEPING;
        System.out.println(this.name + " засыпает");

    }
    public void wakeup() throws NoSleepError{

        if(this.status != Status.SLEEPING) {
            throw new NoSleepError(this.name);
        }
        else {
            status = Status.CHILLING;
            System.out.println(this.name + " просыпается");
        }
    }
    public void wakeup(Entity e) throws NoSleepError{
        if(this.status != Status.SLEEPING) {
            throw new NoSleepError(this.name);
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
    public void wear(Item i) throws InventoryFullError{
        try{
            i.wear();
        }
        catch (Item.ItemBusyError ex){
            System.out.println(ex.getMessage());
            return;
        }


            for(int a = 0; a < 100; a++ ){
                if (this.items[a] == null) {
                    items[a] = i;
                    System.out.println(this.name + " надел " + i.name);
                    return;
                }
            }
            throw new InventoryFullError();

    }
    public void unwear(Item i) throws ItemNotFoundError{
        try{
            i.unwear();
        }
        catch(Item.ItemFreeError ex){
            System.out.println(ex.getMessage());
            return;
        }

        for(int a = 0; a < 100; a++ ) {
            if (this.items[a] == i) {
                this.items[a] = null;
                System.out.println(this.name + " снял " + i.name);
                return;
            }
        }
            throw new ItemNotFoundError();

    }
    public Transport getTransport(){
        return this.transport;
    }
    public void sitTransport(Transport t) throws TransportError{
        if (this.transport != null) {
            throw new TransportError(this.name);
        }
        else{
            this.transport = t;
            System.out.println(this.name + " сел в " + t.name);
        }
    }
    public void leaveTransport() throws NoTransportError{
        if (this.transport == null){
            throw new NoTransportError(this.name);
        }
        else{
            System.out.println(this.name + " вышел из " + this.transport.name);
            this.transport = null;
        }

    }
    public Item[] getItems(){
        return items;
    }
    public void read(String text){
        System.out.println(this.name + " читает: " + text);
    }
    public void think(String text){
        System.out.println(this.name + " думает: " + text);
    }




}

