package ru.ifmo.enviroments;
import ru.ifmo.interfaces.IEnviroment;
public class Enviroment implements IEnviroment{
    private int t_hours;
    private int t_mins;
    private int t_secs;

    public Enviroment(){
        this.t_hours = 0;
        this.t_mins = 0;
        this.t_secs = 0;
    }
    public Enviroment(int h, int m, int s){
        this.t_hours = h % 24;
        this.t_mins = m % 60;
        this.t_secs = s % 60;
    }
    public void setTime(int h, int m, int s){
        this.t_hours = h % 24;
        this.t_mins = m % 60;
        this.t_secs = s % 60;
    }
    public final int[] getTime(){

        return new int[]{this.t_hours, this.t_mins, this.t_secs};
    }
}
