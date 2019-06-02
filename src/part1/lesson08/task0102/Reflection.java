package part1.lesson08.task0102;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Класс для выполеня функции рефлексии
 * void serialize (Object object, String file);
 * Object deSerialize(String file);
 * Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла. Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
 */

public class Reflection {

    public Reflection() {
    }

    /**
     * Функция сохранения объекта на диск
     * @param object - объект
     * @param filename - имя файла для сохранения
     */

    void serialize(Object object, String filename) {
        Class cl = object.getClass();

        try (FileOutputStream out = new FileOutputStream(filename);
             PrintStream ps = new PrintStream(out)) {

            Field fieldMark = cl.getDeclaredField("mark");
            fieldMark.setAccessible(true);
            //ps.println(fieldMark);
            ps.println(fieldMark.get(object));

            Field fieldType = cl.getDeclaredField("type");
            fieldType.setAccessible(true);
            //ps.println(fieldType);
            ps.println(fieldType.get(object));

            Field fieldCount = cl.getDeclaredField("count");
            //ps.println(fieldCount);
            fieldCount.setAccessible(true);
            ps.println(fieldCount.get(object));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Функция чтения объекта с диска
     * @param file - имя файла
     * @return - объект
     */

    Object deSerialize(String file) {
        int mark=0;
        String type = null;
        Integer count=null;
        try(FileInputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader( new InputStreamReader(in))) {
            mark = Integer.parseInt(br.readLine());
            type = br.readLine();
            count = Integer.parseInt(br.readLine());
            System.out.println(mark + type + count);
         }
        catch (Exception ex){
            ex.printStackTrace();
        }
        Test testClass = null;
        try {
            Class cl = Class.forName(Test.class.getName());
            testClass = (Test) cl.newInstance();
            Field typeField = testClass.getClass().getDeclaredField("type");
            typeField.setAccessible(true);
            typeField.set(testClass,type);

            Field markField = testClass.getClass().getDeclaredField("mark");
            markField.setAccessible(true);
            markField.set(testClass,mark);

            Field countField = testClass.getClass().getDeclaredField("count");
            countField.setAccessible(true);
            countField.set(testClass,count);

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return testClass;
    }
}
