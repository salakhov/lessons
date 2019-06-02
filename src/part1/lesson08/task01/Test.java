package part1.lesson08.task01;

/**
 * Тестовый класс для хранения параметров объекта
 *
 */

public class Test {
    private String type;
    private int mark;
    private Integer count;

    public Test(String type, int mark, Integer count) {
        this.type = type;
        this.mark = mark;
        this.count = count;
    }

    public Test() {
    }

    public void printClass() {
        System.out.println(this.type + " " + this.mark + " " + this.count);
    }
}
