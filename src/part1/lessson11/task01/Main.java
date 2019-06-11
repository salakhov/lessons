package part1.lessson11.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Задание11: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там, где это уместно (возможно, жертвуя производительностью)
 */

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            array.add(rnd.nextInt(20));
        }

        ParallelCalc parallelCalc = new ParallelCalc();
        parallelCalc.CalcClassicMethod(array,3);

        array.forEach(System.out::println);
    }


}
