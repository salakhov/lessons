package part1.lesson08.task0102;

/**
 * Тестовый класс для хранения параметров объекта
 */

public class Test {
    private String type;
    private int mark;
    private Integer count;
    private ObjectToSerialize objectToSerialize;

    public Test(String type, int mark, Integer count,ObjectToSerialize serializableObject) {
        this.type = type;
        this.mark = mark;
        this.count = count;
        this.objectToSerialize = serializableObject;
    }

    public Test() {
    }

    public void printClass() {
        System.out.println("SimpleFields {" +
                this.type + " " + this.mark + " " + this.count + "} " + objectToSerialize.toString());
    }
}
