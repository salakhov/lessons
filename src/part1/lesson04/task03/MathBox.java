package part1.lesson04.task03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MathBox<T extends Number> extends ObjectBox {

    /**
     *  * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
     *  * раскладываются в подходящую коллекцию (выбрать самостоятельно).
     * @param number
     */
    public MathBox (T [] number) throws PutObjectToMathBoxException {
        //TODO спросить у ментора в чем проблема
        // if (number.getClass() != Object.class)
        //    throw new PutObjectToMathBoxException("Попытка положить Object в MathBox" + number.getClass());
        for (T num:number)
            collection.add(num);
    }
    /**
     * метод summator, возвращающий сумму всех элементов коллекции.
     */
    public Double summmator(){
        Iterator<T> it = collection.iterator();
        Double sum=0.0;
        while(it.hasNext()) {
            T value = (T) it.next();
            sum = value.doubleValue() + sum;
        }
        return sum;
    }

    /**
     * выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода.
     * Хранящиеся в объекте данные полностью заменяются результатами деления.
     * @param num
     */
    public void splitter(T num){
       //TODO Спросить и ментора в чем разница двух записей Set collectionCopy = new HashSet<T>(); - работает
        //TODO Set <T> collectionCopy = new HashSet<>(); - НЕ работает
        Set collectionCopy = new HashSet<T>();
        Iterator<T> iterator=collection.iterator();
        while(iterator.hasNext()) {
            T value = iterator.next();
            Double d = value.doubleValue() / num.doubleValue();
            collectionCopy.add(d);
            iterator.remove();
        }
        collection=collectionCopy;
    }





}
