package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс занимается вычислением факториала числа
 * cashe - коллекция куда складывается вычисленный факториал для ускорения дальнейших вычислений
 * number - число
 * <p>
 * справочная информация
 * Факториал 170 = 7.257415615307999e+306
 * Integer (MAX: 2147483647, MIN -2147483647)
 * bigInteger 1234567890123456890
 */

public class Factorial implements Runnable {
    private static ConcurrentHashMap<Integer, BigInteger> cache = new ConcurrentHashMap<>();
    private Integer number;

    public Factorial(Integer number) {
        this.number = number;
    }

    /**
     * Функция интеллектуального вычисления факториала с использованием кеша
     *
     * @return
     */
    public BigInteger CalcFactorial() {
        BigInteger result = null;
        //Пытаемся взять из кеша
        if (!cache.isEmpty())
            result = getResultFromCashe();
        //вычисляем факториал по честному
        if (result == null) {
            result = BigInteger.ONE;
            for (int i = 1; i <= this.number; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
        //кладем в кеш
        cache.put(this.number, result);
        return result;
    }

    private BigInteger getResultFromCashe() {
        return cache.get(this.number);
    }

    @Override
    public void run() {
        BigInteger temp = CalcFactorial();
        System.out.println("Factorial " + number + "=" + temp);
    }
}
