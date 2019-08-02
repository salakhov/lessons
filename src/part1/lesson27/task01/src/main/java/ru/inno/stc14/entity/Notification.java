package ru.inno.stc14.entity;

import java.util.Observable;

/**
 * Класс уведомления, СОздан в соответствии с паттерном Наблюдатель.
 * Создан с целью обеспечения уведомления объектов класса JKX
 */

public class Notification extends Observable {
    private String content;
    private String home;

    public void setContent(String content) {this.content = content;}
    public void setHome(String home) {this.home = home;}

    public String getHome() {return home;}

    public Notification() {}

    public void notifyChanges(){
        setChanged();
        notifyObservers();
    }

    public void create(String _content){
        this.content = _content;
        notifyChanges();
    }

    public String getContent(){
        return content;
    }

}
