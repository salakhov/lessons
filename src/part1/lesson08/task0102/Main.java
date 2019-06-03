package part1.lesson08.task0102;

import java.io.*;

/**
Задание 1. Необходимо разработать класс, реализующий следующие методы:
        void serialize (Object object, String file);
        Object deSerialize(String file);
        Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла.
        Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).

 Задание 2. Предусмотреть работу c любыми типами полей (полями могут быть ссылочные типы).

*/

public class Main {

    public static void main(String[] args) {

        Test testClass = null;

        Reflection refl = new Reflection();
        Test test = new Test("typeValue",5,300);

        refl.serialize(test,"lesson08task01.txt");
        testClass = (Test)refl.deSerialize("lesson08task01.txt");
        testClass.printClass();

        try (FileOutputStream fos = new FileOutputStream("Object.ser");
             ObjectOutputStream os = new ObjectOutputStream(fos)){
            ObjectToSerialize objectToSerialize;
            objectToSerialize = new ObjectToSerialize("Moskva",1);
            os.writeObject(objectToSerialize);
            System.out.println(objectToSerialize.toString());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("Object.ser");
            ObjectInputStream is = new ObjectInputStream(fis)){
            ObjectToSerialize obj = (ObjectToSerialize)is.readObject();
            System.out.println(obj.toString());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }


}
