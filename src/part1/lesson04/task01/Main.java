package part1.lesson04.task01;

import java.util.HashMap;
import java.util.Map;

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
        //2 различных массива Numbers
        Number [] numbers = new Number[10];
        for (int i=0;i<numbers.length;i++){
            numbers[i] = i;
        }
        Number [] numbers2 = new Number[11];
        for (int i=0;i<numbers2.length;i++){
            numbers2[i] = i;
        }
         //3 объекта. 2 одинаковых для проверка функций equals,hashset
        MathBox mathBox = new MathBox(numbers);
        MathBox mathBox2 = new MathBox(numbers2);
        MathBox mathBox3= new MathBox(numbers);

        //В карту добавляем 3 объекта. Так как 2 одинаковых - сохраняются 2
        Map<Integer,MathBox> map = new HashMap<Integer,MathBox>();
        map.put(mathBox.hashCode(),mathBox);
        map.put(mathBox2.hashCode(),mathBox2);
        map.put(mathBox2.hashCode(),mathBox3);

        System.out.println("Размер карты:"+map.size());

        //Цикл по карте и вызов функций для каждого MathBox
        for(Map.Entry<Integer, MathBox> item : map.entrySet()){
            System.out.println("\n**** Начальное значение MathBox");
            System.out.println("key: "+item.getKey()+" value:"+item.getValue().toString());
            System.out.println("Summa: "+item.getValue().summmator());
            item.getValue().splitter(2.0);
            System.out.println("Значение MathBox после деления на 2");
            System.out.println("key: "+item.getKey()+" value:"+item.getValue().toString());
            System.out.println("Значение MathBox после удаления 0");
            item.getValue().safeDelete(0.0);
            System.out.println("key: "+item.getKey()+" value:"+item.getValue().toString());
        }
    }
}
