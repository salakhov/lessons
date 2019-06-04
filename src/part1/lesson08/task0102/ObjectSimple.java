package part1.lesson08.task0102;

/**
 * Ссылочный тип, не унаследованный от serilize
 */


public class ObjectSimple {
    private String text;
    private Integer number;

    public ObjectSimple(String text, Integer number) {
        this.text = text;
        this.number = number;
    }

    @Override
    public String toString() {
        return "ObjectSimple{" +
                "text='" + text + '\'' +
                ", number=" + number +
                '}';
    }
}
