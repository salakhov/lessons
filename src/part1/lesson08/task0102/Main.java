package part1.lesson08.task0102;

import java.io.*;

/**
Задание 1. Необходимо разработать класс, реализующий следующие методы:
        void serialize (Object object, String file);
        Object deSerialize(String file);
        Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла.
        Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).

 Задание 2. Предусмотреть работу c любыми типами полей (полями могут быть ссылочные типы).

*/

public class Main {

    public static void main(String[] args) {

        Test testClass = null;
        //Создаем экземпляра, реализующего методы по заданию
        Reflection refl = new Reflection();
        //Создаем экземпляр объекта ссылочного типа (задание 2). Сериализуемый
        ObjectToSerialize objectToSerialize = new ObjectToSerialize("Moskva",10);

        //экземпляр объекта для проверки рефлексии
        Test test = new Test("typeValue",5,300,objectToSerialize);
        //ИСходный объект на печать
        System.out.println("Исходный объект");
        test.printClass();

        //Сериализуем объект с использованием рефлексии
        refl.serialize(test,"lesson08task01.txt");

        //Десерелизуем объект при помощи рефлексии
        testClass = (Test)refl.deSerialize("lesson08task01.txt");

        //Проверяем
        System.out.println("Десериализованный объект");
        testClass.printClass();

    }


}
