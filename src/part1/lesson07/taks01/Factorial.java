package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Факториал 170 = 7.257415615307999e+306
 * Integer (MAX: 2147483647, MIN -2147483647)
 * bigInteger 1234567890123456890
 */

public class Factorial implements Runnable {
    ArrayList <Integer> array;
    static HashMap<Integer,BigInteger> cashe = new HashMap<>();
    public Factorial(ArrayList array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println("factorial"+ array.get(1)+" = "+this.CalcFactorial(10));
        System.out.println("factorial"+ array.get(1)+" = "+this.CalcFactorial(11));
    }

    private BigInteger CalcFactorial(Integer number){

        BigInteger result = BigInteger.ONE;
        BigInteger casheRet = cashe.get(number);
        //проверяем если число есть в кеше возвращаем из кеша.
        if(casheRet!=null) {
            System.out.println("exec from cashe");
            return casheRet;
        }
        //TODO проверяем есть ли в кеше число меньшее

        //вычисляем факториал по честному
        for (int i=1;i<=number;i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        cashe.put(number,result);
        return result;
    }

}
