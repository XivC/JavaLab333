package ru.ifmo;
import ru.ifmo.entities.Entity;
import ru.ifmo.entities.Item;
import ru.ifmo.entities.Person;
import ru.ifmo.enviroments.Place;
import ru.ifmo.entities.Controller;
import ru.ifmo.entities.transport.train.Train;

public class Main {

    public static void main(String[] args) {
	System.out.println("----------ПОДГОТОВКА----------");

	Person Skuper = new Person("Скуперфильд");
	Person nach = new Person("Какой-то железнодорожный начальник");
	Train t1 = new Train("№1");
	Train t2 = new Train("№2");
	Place perron = new Place("Перрон");
	perron.setTime(4,0,0);
	Place dal = new Place("Далёкая даль");
	Place panopt = new Place("Город Паноптикум");
	Item gazeta = new Item("Газета");
	Item cilindr = new Item("Цилиндр");
	Skuper.wear(cilindr);
	Skuper.sitTransport(t1);
	Entity lavochka = new Entity("Лавочка");
	Person[] passangers = new Person[5];
	for(int i = 0; i < 5; i ++ ){
		passangers[i] = new Person("Пассажир " + i);
		passangers[i].sitTransport(t2);
	}
	Controller cont = new Controller("", t1);
	System.out.println("-----------СЦЕНАРИЙ-----------");
	t1.goTo(panopt);
	t1.stop();
	cont.checkTicket(Skuper);
	Skuper.goTo(perron);
	Skuper.stay();
	t1.goTo(dal);
	Skuper.look(t1);
	Skuper.goTo(lavochka);
	Skuper.unwear(cilindr);
	Skuper.wear(gazeta);
	int[] time = perron.getTime();
	System.out.println("Текущее время: " + time[0] + " часа " + time[1] + "минут" );
	Skuper.sleep();
	perron.setTime(6,30,0);
	time = perron.getTime();
	System.out.println("Текущее время: " + time[0] + " часа " + time[1] + "минут" );
	Skuper.wakeup(nach);
	nach.tell("Здесь спать не полагается!");
	t2.goTo(panopt);
	t2.stop();
	for(Person p: passangers){p.leaveTransport();p.goTo(perron);}
	Skuper.stay();
	Skuper.wear(cilindr);
	Skuper.stay();
	Skuper.goTo(panopt);









    }
}
