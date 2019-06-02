package part1.lesson08.task01;

/**
Задание 1. Необходимо разработать класс, реализующий следующие методы:
        void serialize (Object object, String file);
        Object deSerialize(String file);
        Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла.
 Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
*/

public class Main {

    public static void main(String[] args) {

        Test testClass = null;

        Reflection refl = new Reflection();
        Test test = new Test("typeValue",5,300);

        refl.serialize(test,"lesson08task01.txt");
        testClass = (Test)refl.deSerialize("lesson08task01.txt");
        testClass.printClass();

    }


}
