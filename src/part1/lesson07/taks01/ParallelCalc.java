package part1.lesson07.taks01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Класс для паралельной обработки массива чисел в несколько потоков.
 * arrаy - массив элементов для вычисления
 * parralelism - степень паралелизма с которой выполняются потоки. 3 - по умолчанию
 */

public class ParallelCalc {
    private ArrayList<Integer> array;
    private int parralelism;

    public ParallelCalc(ArrayList<Integer> array) {
        this.array = array;
        this.parralelism = 3;
    }

    /**
     * Вычисление факториала обычным методом в несколько потоков.
     * Нечколько чисел вычисляются паралельно
     */
    public void CalcClassicMethod() {
        Thread[] thread = new Thread[parralelism];
        Factorial[] fact = new Factorial[parralelism];

        Iterator it = array.iterator();

        //Цикл по коллекции пока есть элементы
        while (it.hasNext()) {
            //Цикл по потокам, запуск потоков с указанной степенью паралелизма
            for (int calc = 0; calc < thread.length; calc++) {
                try {
                    Integer value = (Integer) it.next();
                    fact[calc] = new Factorial(value);
                    thread[calc] = new Thread(fact[calc]);
                    thread[calc].run();
                } catch (NoSuchElementException err) {
                    //Если кончились элементы и на все потоки не хватило
                    break;
                }
            }
        }
    }
}
