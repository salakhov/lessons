package ru.inno.stc14.entity;

/**
 * Класс фабрика применяется для расширения сиоздаваемых объектов различных типов и различным набором полей
 * Паттерн фабрика необходим для создания объектов различных типов
 * Фабрика используется в AnimalServiceImpl
 */

public class AnimalFactory {
    public Animal create(String human) {
        human = human.toUpperCase();
        if (human.compareTo("HUMAN")==0)
            return new Person();
        return new Pet();
    }

}
