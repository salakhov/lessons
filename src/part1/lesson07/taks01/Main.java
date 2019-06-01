package part1.lesson07.taks01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов массива. Использовать пул потоков для решения задачи.
 * Особенности выполнения:
 * Для данного примера использовать рекурсию - не очень хороший вариант, т.к. происходит большое выделение памяти, очень вероятен StackOverFlow.
 * Лучше перемножать числа в простом цикле при этом создавать объект типа BigInteger
 * По сути, есть несколько способа решения задания:
 * 1) распараллеливать вычисление факториала для одного числа
 * 2) распараллеливать вычисления для разных чисел
 * 3) комбинированный
 * При чем вычислив факториал для одного числа, можно запомнить эти данные и использовать их для вычисления другого, что будет гораздо быстрее
 */

//DONE TODO  1. Thread Pool Executor а не запускать все потоки одновременно
//DONE TODO  2. Разобраться с callable
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //int num = rnd.nextInt(20);
            int num = i;
            array.add(num);
        }

        ParallelCalc parallelCalc = new ParallelCalc(array);
        parallelCalc.CalcClassicMethod();
        //parallelCalc.CalcParallelMethod();

        array.forEach(System.out::println);
    }


}
