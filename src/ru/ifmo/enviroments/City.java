package ru.ifmo.enviroments;
import ru.ifmo.entities.buildings.Building;
public class City extends Place{
    private Building[] buildings;
    public City(String name, Building[] b){
        super("[Город]" + name);
        this.buildings = b;
    }
    public boolean checkBuilding(String name){
        for(Building b : buildings){
            if (b.name.equals("[Здание]"+name)){return true;}
        }
        return false;
    }


}
