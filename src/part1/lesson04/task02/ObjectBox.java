package part1.lesson04.task02;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox {

    public Set<Object> collection = new HashSet<Object>();

    public ObjectBox() {
    }

    /**
     * Функция добавления объекта в коллекцию
     * @param obj
     */
    public void addObject(Object obj){
        collection.add(obj);
    }

    /**
     * Функция удаления объекта из коллекции
     * @param obj
     */
    public void deleteObject(Object obj){
        if(collection.contains(obj)) {
            collection.remove(obj);
        }
    }
    /**
     * Функция печати коллекции
     */
    public void dump() {
        String str = "";
        for (Object obj : collection) {
            str = obj.toString()+";"+str;
        }
        str.replaceAll("\n|\r\n",";");
        System.out.println(str);
    }
}
