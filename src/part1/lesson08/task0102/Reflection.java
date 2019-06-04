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
     * Функция сохранения объекта на диск. Читаем объект по полям, выгружаем с помощью рефлексии
     * и сохраняем посточно в определеном порядке
     * @param object - объект
     * @param filename - имя файла для сохранения
     */

    public void serialize(Object object, String filename) {
        serializeSimpleFields(object, filename);
        serializeSerializableObject(object, "serializable.ser");
    }

    private void serializeSerializableObject(Object object, String filename) {
        Class cl = object.getClass();
        Field [] fields = cl.getDeclaredFields();

        //TODO спросить как проверить что экземпляр унаследован от serializable
        for(Field field:fields) {
            //Определяем является ли объект классом который можно сериализовать
            String fieldTypeStr = field.getType().toString();
            String objectTypeStr = ObjectToSerialize.class.toString();
            if (fieldTypeStr.equals(objectTypeStr)){
                //Сохраняем сериализованный объект
                try (FileOutputStream fos = new FileOutputStream(filename);
                    ObjectOutputStream os = new ObjectOutputStream(fos)){
                    field.setAccessible(true);
                    ObjectToSerialize objectToSerialize = (ObjectToSerialize) field.get(object);
                    //Class<?> c = object.getClass();
                    os.writeObject(objectToSerialize);
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
                catch (IllegalAccessException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Функция сохранения содержимого примитивных типов с помощью рефлексии
     * @param object
     * @param filename
     */

    private void serializeSimpleFields(Object object, String filename){

        Class cl = object.getClass();

        try (FileOutputStream out = new FileOutputStream(filename);
             PrintStream ps = new PrintStream(out)) {

            Field fieldMark = cl.getDeclaredField("mark");
            fieldMark.setAccessible(true);
            ps.println(fieldMark.get(object));

            Field fieldType = cl.getDeclaredField("type");
            fieldType.setAccessible(true);
            ps.println(fieldType.get(object));

            Field fieldCount = cl.getDeclaredField("count");
            fieldCount.setAccessible(true);
            ps.println(fieldCount.get(object));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Функция чтения объекта с диска. Читаем по отдельному полю
     * @param file - имя файла
     * @return - объект
     */

    public Object deSerialize(String file) {
        Test testClass = null;
        testClass = (Test) deserializeSimpleFields(file);
        ObjectToSerialize obj = (ObjectToSerialize) deserializeSerializableFields("serializable.ser");

        try{
            Field objField = testClass.getClass().getDeclaredField("objectToSerialize");
            objField.setAccessible(true);
            objField.set(testClass,obj);
        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }
        catch (NoSuchFieldException ex){
            ex.printStackTrace();
        }
        return testClass;
    }

    /**
     * Функция загрузки примитивных типов
     * @param file
     * @return
     */
    private Object deserializeSimpleFields(String file){
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

    /**
     * функция загрузки ссылочного объекта
     * @param file
     * @return
     */

    private Object deserializeSerializableFields(String file){
        ObjectToSerialize objSerializable=null;

        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(fis)){
            objSerializable = (ObjectToSerialize)is.readObject();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return objSerializable;
    }
}
