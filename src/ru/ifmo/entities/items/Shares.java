package ru.ifmo.entities.items;

import ru.ifmo.interfaces.ICost;

public class Shares extends Item implements ICost {
    private int cost;
    public Shares(String name, int cost) throws Exception{
        super("[Акции]" + name);
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public void changeCost(int cost){
        this.cost = cost;
    }
}
