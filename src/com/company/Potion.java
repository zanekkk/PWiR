package com.company;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Potion {
    private int counter = 0;
    private Image image;
    private int x , y ;
    private boolean GoToCauldron = false;
    private boolean ereas = false;
    private int number ;
    private int cauldronNumber;

    public Potion(String color, int number, int cauldronNumber){
        this.number = number;
        this.cauldronNumber = cauldronNumber;

        try{
        if(color == "RED"){
            image = new Image("src/resources/redPOTION.png");
            x = 150;
            y = 330;
        }else if(color == "BLUE"){
            image = new Image("src/resources/bluePOTION.png");
            x = 150;
            y = 210;
        }
        }catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isGoToCauldron() {
        return GoToCauldron;
    }

    public void setGoToCauldron(boolean goToCauldron) {
        GoToCauldron = goToCauldron;
    }

    public int getNumber() {
        return number;
    }

    public boolean isEreas() {
        return ereas;
    }

    public void setEreas(boolean ereas) {
        this.ereas = ereas;
    }

    public int getCauldronNumber() {
        return cauldronNumber;
    }

    public void setCauldronNumber(int cauldronNumber) {
        this.cauldronNumber = cauldronNumber;
    }
}
