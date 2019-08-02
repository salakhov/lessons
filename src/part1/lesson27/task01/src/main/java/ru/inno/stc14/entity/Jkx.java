package ru.inno.stc14.entity;

import java.util.Observable;
import java.util.Observer;

/**
 * Класс JKХ. Является подписчиком на изменения в классе Home
 * При добавлении жителя или питомца происходит уведомление жкземпляра класса
 * */

public class Jkx implements Observer {
    private String name;

    public Jkx(String name, Observable observable) {
        this.name = name;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg){
        if( observable instanceof Notification){
            System.out.println("NITIFICATIO " + name +" passed");
        }
    }
}
