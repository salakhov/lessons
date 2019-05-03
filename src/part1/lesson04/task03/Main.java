package part1.lesson04.task03;

import java.util.HashMap;
import java.util.Map;

/**
 * Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 * Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться.
 * При попытке положить Object в MathBox должно создаваться исключение.
 */

public class Main {
    public static void main(String[] args) throws PutObjectToMathBoxException{

        Integer [] numbers = new Integer[10];
        Double [] numbers2 = new Double[11];

        for (int i=0;i<numbers.length;i++){
            numbers[i] = i;
        }
        int j;
        double i;
        for (i=0.5,j=0;i<numbers2.length;i++,j++){
            numbers2[j] = i;
        }
        MathBox<Integer> mathBox1;
        MathBox<Double> mathBox2;

        mathBox1= new MathBox<Integer>(numbers);
        mathBox2= new MathBox<Double>(numbers2);

        Map<Integer,ObjectBox> map = new HashMap<>();
        map.put(map.hashCode(),mathBox1);
        map.put(map.hashCode(),mathBox2);

        for(Map.Entry<Integer, ObjectBox> item : map.entrySet()){
            System.out.println("\n**** Начальное значение ObjectBox");
            MathBox mathBoxTemp = (MathBox)item.getValue();
            System.out.println("Objkey: "+item.getKey()+" Objvalue:"+mathBoxTemp.toString());
            System.out.println("Summa: "+mathBoxTemp.summmator());
            mathBoxTemp.splitter(2.0);
            System.out.println("Значение ObjectBox после деления на 2");
            System.out.println("key: "+item.getKey()+" value:"+mathBoxTemp.toString());
            System.out.println("Значение ObjectBox после удаления 0");
            mathBoxTemp.safeDelete(0.0);
            System.out.println("key: "+item.getKey()+" value:"+mathBoxTemp.toString());
        }


    }
}