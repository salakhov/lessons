package part1.lesson08.task0102;

import java.io.Serializable;

/**
 * Ссылочный объект для загрузки через рефлексию с использованием интерфейса serializable
 */

public class ObjectToSerialize implements Serializable {
    private String objectName;
    private Integer objectCount;

    public ObjectToSerialize(String objectName, Integer objectCount) {
        this.objectName = objectName;
        this.objectCount = objectCount;
    }

    @Override
    public String toString() {
        return "ObjectToSave{" +
                "objectName='" + objectName + '\'' +
                ", objectCount=" + objectCount +
                '}';
    }
}
