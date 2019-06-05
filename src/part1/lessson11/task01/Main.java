package part1.lessson11.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Задание11: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там, где это уместно (возможно, жертвуя производительностью)
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
