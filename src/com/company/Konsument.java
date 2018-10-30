package com.company;


public class Konsument extends Thread{
    private Pojemnik pojemnik;
    private Pojemnik pojemnik2;
    private String name;

    public Konsument(Pojemnik pojemnik, Pojemnik pojemnik2, String name) {
        this.pojemnik = pojemnik;
        this.pojemnik2 = pojemnik2;
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((int) (100 * Math.random()));
            }
            catch (InterruptedException e){ }
            pojemnik.pobierz(name, 1);
            pojemnik2.pobierz(name, 2);

        }
    }
}
