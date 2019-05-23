package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Факториал 170 = 7.257415615307999e+306
 * Integer (MAX: 2147483647, MIN -2147483647)
 * bigInteger 1234567890123456890
 */

public class Factorial implements Runnable {
    ArrayList <Integer> array;
    public Factorial(ArrayList array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println("factorial"+ array.get(1)+" = "+this.CalcFactorial(400));
    }

    private BigInteger CalcFactorial(Integer number){

        BigInteger result = BigInteger.ONE;
        for (int i=1;i<=number;i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
