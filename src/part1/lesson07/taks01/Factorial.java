package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Факториал 170 = 7.257415615307999e+306
 * Integer (MAX: 2147483647, MIN -2147483647)
 * bigInteger 1234567890123456890
 */

public class Factorial implements Runnable {
    private static ConcurrentHashMap<Integer, BigInteger> cashe = new ConcurrentHashMap<>();
    private Integer number;

    public Factorial(Integer number) {
        this.number = number;
    }

    public BigInteger CalcFactorial() {
        BigInteger result = BigInteger.ONE;
        BigInteger casheRet = cashe.get(this.number);
        //проверяем если число есть в кеше возвращаем из кеша.
        if (casheRet != null) {
            //System.out.println("exec from cashe");
            return casheRet;
        }
        //TODO проверяем есть ли в кеше число меньшее

        //вычисляем факториал по честному
        for (int i = 1; i <= this.number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        cashe.put(this.number, result);
        return result;
    }

    public BigInteger CalcFactorial(Integer number){
        this.number = number;
        return CalcFactorial();
    }

    public BigInteger CalcParallelFactorial(int delimeter){
        BigInteger result = BigInteger.ONE;
//        int [delimeter] number;
//        for(int i=0;i<delimeter;i++){
//            number [i] = this.number %=delimeter;
//        }
        return result;
    }


    @Override
    public void run() {
        BigInteger temp = CalcFactorial();
        System.out.println("Factorial " + number + "=" + temp);
    }

//    private void IntervalFactorialCalc() {
//        System.out.println("Вычисляем факториал числа по интервалам");
//        System.out.println("Делим число на интервалы");
//    }
//
//    private Integer CalcOptimalInterval(){
//        return 3;
//    }
}
