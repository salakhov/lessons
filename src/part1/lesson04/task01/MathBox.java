package part1.lesson04.task01;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MathBox {
    private HashSet collection = new HashSet<Number>();

    /**
     *  * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
     *  * раскладываются в подходящую коллекцию (выбрать самостоятельно).
     * @param number
     */
    public MathBox(Number [] number) {
        for (Number num:number)
            collection.add(num);
    }

    public void printCollection(){
        Iterator<Number> it = collection.iterator();
        while(it.hasNext())
            System.out.println(it.next());

    }

    /**
     * метод summator, возвращающий сумму всех элементов коллекции.
     */
    public int summmator(){
        Iterator<Number> it = collection.iterator();
        Integer sum=0;
        while(it.hasNext())
            sum=it.next().intValue()+sum;
        return sum;
    }

    /**
     * выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода.
     * Хранящиеся в объекте данные полностью заменяются результатами деления.
     * @param num
     */
    public void splitter(int num){
        Iterator<Number> it=collection.iterator();
        while (it.hasNext()) {
            collection.add(d);
            collection.remove(it.next());
        }

    }

    /**
     * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
     */
    public void delete(int num){

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
