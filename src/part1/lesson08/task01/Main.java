package part1.lesson08.task01;

import java.lang.reflect.Field;

/**
Задание 1. Необходимо разработать класс, реализующий следующие методы:
        void serialize (Object object, String file);
        Object deSerialize(String file);
        Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла. Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
*/

public class Main {

    public static void main(String[] args) {

        Reflection refl = new Reflection();
        Class cl = refl.getClass();

        Field [] field = refl.getClass().getDeclaredFields();

        int i=refl.getClass().getModifiers();
        System.out.println(i);

    }


}
