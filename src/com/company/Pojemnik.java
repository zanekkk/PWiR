package com.company;

import java.util.LinkedList;

public class Pojemnik {
    private int number = 0;
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private final int LIMIT = 5;   //limit ilosci miejsc wstawianych do tablicy

    synchronized public void pobierz(String nazwa, int numer) {
        while(linkedList.size() == 0){
            try {
                wait();
                System.out.println(" Proces " + nazwa + " czeka z pobraniem z pojemnika nr " + numer);
            } catch (InterruptedException e) {
            }}
        System.out.println(" [Z pojemnika nr " + numer + " pobierana jest wartosc: " + linkedList.getFirst() + " Thread: " + nazwa + "]");
        linkedList.removeFirst();
        notifyAll();
    }

    synchronized public void wstaw(int liczba, String nazwa, int numer) {
        while(linkedList.size() == 10){
            try {
                wait();
                System.out.println(" Proces " + nazwa + " czeka z wstawieniem do pojemnika nr " + numer);
            } catch (InterruptedException e) {
            }}
        System.out.println(" [Do pojemnika nr " + numer +" wstawiana jest wartosc: "
                + liczba + " Thread: " + nazwa + "]");
        linkedList.add(liczba);
        notify();
    }


}
