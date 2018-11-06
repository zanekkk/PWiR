package com.company;

import java.util.LinkedList;

public class Pojemnik {
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private final int LIMIT = 5;   //limit ilosci miejsc wstawianych do tablicy
    private Animation animation;

    public Pojemnik(Animation animation){
        this.animation = animation;
    }

    synchronized public void pobierz(String nazwa, int numer) {
        while(linkedList.size() == 0){
            try {
                wait();
                System.out.println(" {Watek " + nazwa + " czeka z pobraniem z pojemnika nr " + numer + "}");
            } catch (InterruptedException e) {
            }}
        System.out.println(" Z pojemnika nr " + numer + " pobierana jest wartosc: " + linkedList.getFirst() + " Thread: " + nazwa + " ");
        linkedList.removeFirst();
        notify();
    }

    synchronized public void wstaw(int liczba, String nazwa, int numer) {
        while(linkedList.size() == LIMIT){
            try {
                wait();
                System.out.println(" {Watek " + nazwa + " czeka z wstawieniem do pojemnika nr " + numer + "} ");
            } catch (InterruptedException e) {
            }}
        System.out.println(" Do pojemnika nr " + numer +" wstawiana jest wartosc: "
                + liczba + " Thread: " + nazwa + " ");
        linkedList.add(liczba);
        animation.setCollides(true);
        notify();
    }


}
