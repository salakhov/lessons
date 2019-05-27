package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Set;
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
        BigInteger result=null;
        //Пытаемся взять из кеша
        if(!cashe.isEmpty())
            result = getResultFromCashe();

        //вычисляем факториал по честному
        if(result==null) {
            result = BigInteger.ONE;
            for (int i = 1; i <= this.number; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
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

    private Integer getNearestValue() {
        Set<Integer> keys = cashe.keySet();
        Iterator <Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            Integer nextValue = it.next();
            if (nextValue > number) {
                return value;
            }
        }
        return null;
    }

    private BigInteger getResultFromCashe() {
        BigInteger result = cashe.get(this.number);
//        if(result==null) {
//            System.out.println("Found in cashe");
//            Integer nerestValue = getNearestValue();
//            if (nerestValue != null) {
//                BigInteger nerestValueFactor = cashe.get(nerestValue);
//                for (int i = nerestValue; i < this.number; i++) {
//                    result = result.multiply(BigInteger.valueOf(i));
//                }
//            }
//        }
        if(result!=null){
            System.out.println("Took from cashe");
        }
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
