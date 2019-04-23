package part1.lesson02.task02;

import java.util.Random;

/**
 * Задание 2. Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */

/*замечания от 23.04.2019
1. не выполнено условие квадрат целой части. надо взять целую часть
2. подумать надо точностью. возможно как то ее задать
 */

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        //TODO -- double[] random = {-4, 5.6, 9, 6, 5, 6, 7, 1, 2, 8};
        Double[] array = new Double[50];
        for (int i = 0; i < array.length; i++) {
            //TODO -- array[i] = random[i];
            array[i] = random.nextDouble();
        }
        for (Double aDouble : array) {
            try {
                calculateSqrt(aDouble);
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Функция отображения корня чисел.
     * Если в массиве есть отрицательное число - выбрасывается исключение
     * Если квадрат корня числа равен самому числу - печать
     * @param array - массив случайных чисел
     */
    private static void calculateSqrt(Double number) throws NegativeNumberException {
        double sqr;
        if (number < 0) {
            String msg = "Значение числа " + number + " меньше 0 " + " корень не вычисляется";
            throw new NegativeNumberException(msg);
        }
        sqr = Math.sqrt(number);
        // TODO ---- DELETE System.out.println("Корень " + number + " равен " + sqr);
        if (number == Math.pow(sqr, 2)) {
            System.out.println("Квадрат " + sqr + " равен " + number);
        }
    }
}
