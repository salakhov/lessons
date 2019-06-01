package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * Класс для паралельной обработки массива чисел в несколько потоков.
 * arrаy - массив элементов для вычисления
 * parralelism - степень паралелизма с которой выполняются потоки. 3 - по умолчанию
 */

public class ParallelCalc {
    private List<Integer> array;
    private int parralelism;

    public ParallelCalc(List<Integer> array) {
        this.array = array;
        this.parralelism = 3;
    }

    /**
     * Вычисление факториала обычным методом в несколько потоков.
     * Нечколько чисел вычисляются паралельно
     */
    public void CalcClassicMethod() {
        Factorial[] fact = new Factorial[parralelism];

        Iterator it = array.iterator();
        Future[] future = new Future[parralelism];
        ExecutorService service = null;
        //Цикл по коллекции пока есть элементы
        while (it.hasNext()) {
            //Цикл по потокам, запуск потоков с указанной степенью паралелизма
            for (int calc = 0; calc < parralelism; calc++) {
                try {
                    Integer value = (Integer) it.next();
                    fact[calc] = new Factorial(value);
                    service = Executors.newFixedThreadPool(parralelism);
                    future[calc] = service.submit(fact[calc]);

                } catch (NoSuchElementException err) {
                    break;
                } finally {
                    service.shutdown();
                }
            }
        }
    }

    /**
     * Вычисление распаралеливанием одного числа. Черновик
     */

    public void CalcParallelMethod() {

//        for (Integer i : array) {
//            //Integer value = it.next();
//            Integer value = i;
//            Integer middleValue = Math.abs(value / 2);
//
//            ParallelFactorial calc1 = new ParallelFactorial(1, middleValue);
//            ParallelFactorial calc2 = new ParallelFactorial(middleValue + 1, value);
//            ExecutorService execute=null;
//            Future future1;
//            Future future2;
//            try {
//                 execute = Executors.newFixedThreadPool(2);
//
//                future1 = execute.submit(calc1);
//
//                future2 = execute.submit(calc2);
//
//                BigInteger result1 = (BigInteger) future1.get();
//                BigInteger result2 = (BigInteger) future2.get();
//                BigInteger result = result1.multiply(result2);
//
//                System.out.println("factorial " + value + " "+ result1 );
//
//            } catch (Exception err) {
//                err.printStackTrace();
//            }
//            finally {
//                if(execute!=null)
//                    execute.shutdown();
//
//            }
//        }


    }
}
