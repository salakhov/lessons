package part1.lesson04.task01;
import java.util.*;

public class MathBox {
    private Set<Number> collection = new HashSet<>();

    /**
     *  * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
     *  * раскладываются в подходящую коллекцию (выбрать самостоятельно).
     * @param number - массив Number
     */
    public MathBox(Number [] number) {
        for (Number num:number) {
            collection.add(num);
        }
    }

    /**
     * метод summator, возвращающий сумму всех элементов коллекции.
     */
    public int summmator(){
        Iterator it = collection.iterator();
        Integer sum=0;
        while(it.hasNext())
            sum=(Integer) it.next()+sum;
        return sum;
    }

    /**
     * Деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода.
     * Хранящиеся в объекте данные полностью заменяются результатами деления.
     * @param num
     */
    public void splitter(Double num){
        Set collectionCopy = new HashSet<Double>();
        Iterator<Number> iterator=collection.iterator();
        while(iterator.hasNext()) {
            Double d = iterator.next().doubleValue() / num;
            collectionCopy.add(d);
            iterator.remove();
        }
        collection=collectionCopy;
    }

    /**
     * Метод, который получает на вход Number и если такое значение есть в коллекции, удаляет его.
     */
    public void safeDelete(Number num){
        if(collection.contains(num)){
            collection.remove(num);
        }
    }

    public Set<Number> getCollection() {
        return collection;
    }

    /**
     * переопределени hashcode. Вычисляется на основании хешкода строки, полученной из всех элементов коллекции
     * @return
     */
    @Override
    public int hashCode() {
        //return collection.hashCode();
        String str="";
        for (Number num:collection) {
            str = num.toString() + str;
        }
        return str.hashCode();
    }

    /**
     * Переопределение функции равентсва двух объектов. Два объекта равны если равны содержимое коллекций
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        MathBox mathBox2 = (MathBox)obj;
        Set<Number> collection2 = mathBox2.getCollection();
        Iterator<Number> iterator1=collection.iterator();
        Iterator<Number> iterator2=mathBox2.getCollection().iterator();
        boolean result = true;
        if(collection.size()==collection2.size()){
            while(iterator1.hasNext()){
                Number first =iterator1.next();
                Number second =iterator2.next();
                if(!first.equals(second)){
                    result =false;
                    break;
                }
            }
        }
        else
            result=false;

        return result;
    }

    /**
     * Переопределение метода toString. печать всех элементов коллекции через точку с запятой
     * @return
     */
    @Override
    public String toString() {
        Iterator it = collection.iterator();
        String result="";
        while(it.hasNext())
            result = it.next().toString()+";"+result;
        return result;
    }
}
