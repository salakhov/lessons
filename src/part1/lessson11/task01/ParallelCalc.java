package part1.lessson11.task01;

import java.util.List;
import java.util.concurrent.Executors;


/**
 * Класс для паралельной обработки массива чисел в несколько потоков.
 * arrаy - массив элементов для вычисления
 * parralelism - степень паралелизма с которой выполняются потоки. 3 - по умолчанию
 */

public class ParallelCalc {

    public ParallelCalc() {

    }

    /**
     * Вычисление факториала обычным методом в несколько потоков.
     * Нечколько чисел вычисляются паралельно
     */
    public void CalcClassicMethod(List<Integer> array, int parralelism) {
        array.forEach((value) -> Executors.newFixedThreadPool(parralelism).submit(new Factorial(value)));
    }
}
