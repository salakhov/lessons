package part1.lesson04.task02;

/**
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 * У класса должен быть метод addObject, добавляющий объект в коллекцию.
 * У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * Должен быть метод dump, выводящий содержимое коллекции в строку.
 */


public class Main {
    public static void main(String[] args) {
        Object [] objects=new Object[3];
        objects[0] = "String";
        Integer value = new Integer(2);
        objects[1] = value;
        objects[2] = new Double(4.5);

        ObjectBox objBox = new ObjectBox();

        for(int i=0;i<objects.length;i++){
            objBox.addObject(objects[i]);
        }
        System.out.println("Печать элементов объекта");
        objBox.dump();
        System.out.println("Печать элементов объекта после удаление 2");
        objBox.deleteObject(objects[2]);
        objBox.dump();
    }
}
