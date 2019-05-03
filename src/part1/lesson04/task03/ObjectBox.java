package part1.lesson04.task03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ObjectBox <T> {

    public Set<T> collection = new HashSet<>();

    public ObjectBox() {
    }

    public void addObject(T obj){
        collection.add(obj);
    }

    public void deleteObject(T obj){
        if(collection.contains(obj)) {
            collection.remove(obj);
        }
    }

    public Set<T> getCollection() {
        return collection;
    }

//    public void dump() {
//        System.out.println("collection: ");
//        String str = "";
//        for (Object obj : collection) {
//            str = obj.toString()+";"+str;
//        }
//        str.replaceAll("\n|\r\n",";");
//        System.out.println(str);
//    }

    @Override
    public int hashCode() {
        //return collection.hashCode();
        String str="";
        for (T obj:collection) {
            str = obj.hashCode() + str;
        }
        return str.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ObjectBox box2 = (ObjectBox) obj;
        Set<T> collection2 = box2.getCollection();
        Iterator<T> iterator1=collection.iterator();
        Iterator<T> iterator2=box2.getCollection().iterator();
        boolean result = true;
        if(collection.size()==collection2.size()){
            while(iterator1.hasNext()){
                T first =iterator1.next();
                T second =iterator2.next();
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

    @Override
    public String toString() {
        Iterator <T> it = collection.iterator();
        String result="";
        while(it.hasNext())
            result = it.next().toString()+";"+result;
        return result;
    }

    public void safeDelete(T num){
        if(collection.contains(num)){
            collection.remove(num);
        }
    }
}
