package part1.lesson07.taks01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ParallelCalc {
    private ArrayList<Integer> array;
    private int parralelism;

    public ParallelCalc(ArrayList<Integer> array) {
        this.array = array;
        this.parralelism = 3;
    }

    public void CalcClassicMethod() {
        Thread[] thread = new Thread[parralelism];
        Factorial[] fact = new Factorial[parralelism];

        Iterator it = array.iterator();

        //Цикл по коллекции пока есть элементы
        while (it.hasNext()) {
                //Цикл по потокам, запуск потоков с указанной степенью паралелизма
                for (int calc = 0; calc < thread.length; calc++) {
                    try {
                        Integer value = (Integer) it.next();
                        fact[calc] = new Factorial(value);
                        thread[calc] = new Thread(fact[calc]);
                        thread[calc].run();
                    }
                    catch (NoSuchElementException err){
                        //Если кончились элементы и на все потоки не хватило
                        break;
                    }
                }
            }

//        Thread thread1 = new Thread(new Factorial(array.get(0)));
//        Thread thread2 = new Thread(new Factorial(array.get(1)));
//
//        Thread thread3 = new Thread(new Factorial(20));
//        Thread thread4 = new Thread(new Factorial(20));

//        thread1.run();
//        thread2.run();
//        thread3.run();
//        thread4.run();

    }

    public void CalcParallelMethod(){


    }
}
