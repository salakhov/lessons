package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


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

    public void CalcParallelMethod() {
        //Iterator <Integer> it = array.iterator();

        //while (it.hasNext()) {
        for (Integer i : array) {
            //Integer value = it.next();
            Integer value = i;
            Integer middleValue = Math.abs(value / 2);

            ParallelFactorial calc1 = new ParallelFactorial(1, middleValue);
            ParallelFactorial calc2 = new ParallelFactorial(middleValue+1, value);
            try {
                ExecutorService execute1 = Executors.newFixedThreadPool(2);
                Future future1;
                future1 = execute1.submit(calc1);
                Future future2;
                future2 = execute1.submit(calc2);

                BigInteger result1 = (BigInteger) future1.get();
                BigInteger result2 = (BigInteger) future2.get();

                System.out.println(result1 + " " + result2);

            } catch (Exception err) {
                err.printStackTrace();
            }
        }


    }
}
