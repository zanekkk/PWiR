package com.company;


class Producent extends Thread {
    private Pojemnik pojemnik;
    private String nazwa;
    private int numer;
    private Animation animation;

    public Producent(Pojemnik pojemnik, String nazwa, int numer) {
        this.pojemnik = pojemnik;
        this.nazwa = nazwa;
        this.numer = numer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((int) (10000));
            } catch (InterruptedException e) {
            }
            pojemnik.wstaw(i, nazwa, numer);
        }
    }
}

