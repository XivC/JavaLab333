package ru.ifmo.entities.items;
import java.lang.Math;
public class Gazeta extends Item{
    public Gazeta(String name) throws Exception{
        super(name);
    }
    public class Sheet{
        private int number;
        private String text;
        private String header;
        public Sheet(int number, String header, String text){
            this.number = number;
            this.text = text;
            this.header = header;

        }
        public String[] getText(){
            return new String[] {this.header,this.text};
        }
        public int getNumber(){
            return this.number;
        }
    }
    private Sheet[] sheets = new Sheet[10];
    public void changeSheet(int number, String header, String text) throws RuntimeException{
        if (Math.abs(number) > 10) throw new RuntimeException("Номер страницы превышает допустимый");
        else sheets[number] = new Sheet(number, header, text);
    }
    public Sheet[] getSheets(){
        return this.sheets;
    }



}
