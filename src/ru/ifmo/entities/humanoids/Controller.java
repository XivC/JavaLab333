package ru.ifmo.entities.humanoids;
import ru.ifmo.entities.items.Item;
import ru.ifmo.entities.transport.Transport;

public class Controller extends Person {
    public static class NoPassangerError extends RuntimeException{
        public NoPassangerError(Person p){
            super("Не удалось высадить " + p.name + " т.к транспорт контроллёра несоответствует транспорту " + p.name);
        }
    }
    public Controller(String name, Transport t) throws Exception{
        super("[Контролёр] " + name);
        this.sitTransport(t);
    }
    public void checkTicket(Person p) throws Controller.NoPassangerError{
        if(p.getTransport() == this.getTransport() && this.getTransport() != null){
            for(Item i: p.getItems()){
                if(i != null){if(i.name.equals("Билет")) {return;}}

            }
            System.out.println(this.name + " высадил " + p.name + " из " + p.getTransport().name);
            kick(p);
        }
        else throw new Controller.NoPassangerError(p);
    }
    private void kick(Person p){
        p.leaveTransport();
    }
}
