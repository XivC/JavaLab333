package ru.ifmo.entities.transport.train;
import ru.ifmo.entities.transport.Transport;
import ru.ifmo.enviroments.Place;

public class Train extends Transport {


    public enum Status{
        STOPPING,
        MOVING
    }
    private Status status;
    private float speed = 0;


    public Train(String name) throws Exception {
        super("Поезд " + name);
        this.status = Status.MOVING;
    }

    public float getSpeed(){return speed;}
    public void goTo(Place e){
        this.speed = 50.0f;
        System.out.println(this.name + " поехал в " + e.name);
        this.status = Status.MOVING;
    }
    public void stop(){
        this.speed = 0f;
        this.status = Status.STOPPING;

    }
    public void notify(String text){
        System.out.println(this.name + " оповещает: " + text);
    }
}
