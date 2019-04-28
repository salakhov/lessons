package part1.lesson04.task01;

import java.util.concurrent.ForkJoinPool;

/**
 * Задание 1. Написать класс MathBox, реализующий следующий функционал:
 *
 * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
 * раскладываются в подходящую коллекцию (выбрать самостоятельно).
 *
 * Существует метод summator, возвращающий сумму всех элементов коллекции.
 *
 * Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода.
 * Хранящиеся в объекте данные полностью заменяются результатами деления.
 *
 * Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox
 * для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 * Выполнение контракта обязательно!
 * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */

public class Main {
    public static void main(String[] args) {
        Number [] numbers = new Number[10];
        for (int i=0;i<numbers.length;i++){
            numbers[i] = i;
        }

        MathBox mathBox = new MathBox(numbers);
        mathBox.printCollection();
        System.out.println("Summa: "+mathBox.summmator());
        mathBox.splitter(2);
        mathBox.printCollection();

    }

}
