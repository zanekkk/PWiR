package com.company;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Main {
    public static void main(String args[]) {


        Pojemnik poj1 = new Pojemnik();
        Pojemnik poj2 = new Pojemnik();

        Producent prod = new Producent(poj1, "Producent", 1);
        Producent prod2 = new Producent(poj2, "Producent2",2);

        Konsument kons = new Konsument(poj1 , poj2 ,"Konsument1");
        Konsument kons2 = new Konsument(poj1, poj2 , "Konsument2");
        Konsument kons3 = new Konsument(poj1, poj2 ,"Konsument3");



        prod.start();
        prod2.start();
        kons.start();
        kons2.start();
        kons3.start();


    }
}
