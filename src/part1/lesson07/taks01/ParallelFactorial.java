package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class ParallelFactorial implements Callable<BigInteger> {
    private Integer number1;
    private Integer number2;

    public ParallelFactorial(Integer number1, Integer number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    private BigInteger CalcMultiplication() {
        BigInteger result = BigInteger.valueOf(this.number1);
        for (int i = this.number1+1; i <= this.number2; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    @Override
    public BigInteger call() throws Exception {
        return CalcMultiplication();
    }
}
