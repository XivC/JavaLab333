package ru.ifmo;
import ru.ifmo.entities.Entity;
import ru.ifmo.entities.items.Cilindr;
import ru.ifmo.entities.items.Item;
import ru.ifmo.entities.humanoids.Person;
import ru.ifmo.entities.items.Shares;
import ru.ifmo.enviroments.Place;
import ru.ifmo.entities.humanoids.Controller;
import ru.ifmo.entities.transport.train.Train;
import ru.ifmo.entities.buildings.Building;
import ru.ifmo.enviroments.City;
import ru.ifmo.entities.items.Gazeta;

public class Main {

    public static void main(String[] args) throws Exception {
	System.out.println("----------ПОДГОТОВКА----------");

	Person Skuper = new Person("Скуперфильд");
	Person nach = new Person("Какой-то железнодорожный начальник");
	Train t1 = new Train("№1");
	Train t2 = new Train("№2");
	Place perron = new Place("Перрон");
	perron.setTime(4,0,0);
	Place dal = new Place("Далёкая даль");
	City panopt = new City("Город Паноптикум", new Building[] {
			new Building("Перрон"),
			new Building("Пивнушка")
	});
	Gazeta gazeta = new Gazeta("");


	Cilindr cilindr = new Cilindr("Цилиндр", 10, 5);

	Shares shares = new Shares("гигантские акции",300);
	Skuper.wear(cilindr);
	Skuper.sitTransport(t1);
	Entity lavochka = new Entity("Лавочка");
	Person[] passangers = new Person[5];
	for(int i = 0; i < 5; i ++ ){
		passangers[i] = new Person("Пассажир " + i);
		passangers[i].sitTransport(t2);
	}

	Controller cont = new Controller("", t1);
	gazeta.changeSheet(1, "Статья про гигантские акции", "Бла бла бла бла бла бла бла бла");
	City dav = new City("Давилон", new Building[]{
			new Building("Рынок акций")
	});
	City grab = new City("Грабенберг", new Building[]{
			new Building("Рынок акций")
	});
	City sant = new City("Сан-Комарик", new Building[]{
			new Building("Рынок акций")
	});
	City breh = new City("Брехенвиль", new Building[]{
			new Building("Какое-то там здание")
	});

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
	System.out.println("Текущее время: " + time[0] + " часа " + time[1] + " минут" );
	Skuper.sleep();
	perron.setTime(6,30,0);
	time = perron.getTime();
	System.out.println("Текущее время: " + time[0] + " часа " + time[1] + " минут" );
	Skuper.wakeup(nach);
	nach.tell("Здесь спать не полагается!");
	t2.goTo(panopt);
	t2.stop();
	for(Person p: passangers){p.leaveTransport();p.goTo(perron);}
	Skuper.stay();
	Skuper.wear(cilindr);
	Skuper.stay();
	Skuper.goTo(panopt);
	Skuper.look(gazeta);
	Skuper.read(gazeta.getSheets()[1].getText()[0]);
	Skuper.think("Я бы хотел купить " + shares.name +" если бы они стоили меньше ♂" + shares.getCost() + " BUCKS♂");
	shares.changeCost(200);
	Skuper.think("Я бы мог заработать на этом ♂" + (100 * 300 - shares.getCost()) + " BUCKS♂");
	String shar_c = "";
	String no_shar_c = "";
	if (breh.checkBuilding("Рынок акций")) shar_c += breh.name + ",";
	else no_shar_c += breh.name + ",";
	if (dav.checkBuilding("Рынок акций")) shar_c += dav.name + ",";
	else no_shar_c += dav.name + ",";
	if (grab.checkBuilding("Рынок акций")) shar_c += grab.name + ",";
	else no_shar_c += grab.name + ",";
	if (sant.checkBuilding("Рынок акций")) shar_c += sant.name + ",";
	else no_shar_c += sant.name + ",";
	Skuper.think(String.format("Мне следовало бы находится не в (%s), а в (%s) т.к только там есть акционный рынок", no_shar_c, shar_c));





    }
}
