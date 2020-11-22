package ru.ifmo.entities;
import ru.ifmo.entities.transport.Transport;

public class Controller extends Person{

    public Controller(String name, Transport t){
        super("[Контролёр] " + name);
        this.sitTransport(t);
    }
    public void checkTicket(Person p){
        if(p.getTransport() == this.getTransport() && this.getTransport() != null){
            for(Item i: p.getItems()){
                if(i != null){if(i.name == "Билет") {return;}}

            }
            System.out.println(this.name + " высадил " + p.name + " из " + p.getTransport().name);
            kick(p);
        }
        else{
            throw new RuntimeException("Не удалось высадить " + p.name + " т.к транспорт контроллёра несоответствует транспорту " + p.name);
        }
    }
    private void kick(Person p){
        p.leaveTransport();
    }
}
