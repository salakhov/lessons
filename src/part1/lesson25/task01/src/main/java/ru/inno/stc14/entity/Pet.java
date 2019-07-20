package ru.inno.stc14.entity;

/**
 * Класс домашних животных
 */

public class Pet implements Animal {
    private int id;
    String name;
    String master;
    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void create() {
    }

    /**
     *Функция возвращает класс животного (разумный для человека с именем, фамилией или не разумный, кличка и имя владельца)
     */

    @Override
    public String getAnimalType() {
        return "NoHuman";
    }
}
