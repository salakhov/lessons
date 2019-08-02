package ru.inno.stc14.entity;

/**
 * Класс домашних животных. Отличаетс от человека наличием поля хозяин,
 * так как домашнее животное не может жить в доме без человека
 */

public class Pet implements HomeMember {
    private int id;
    private String name;
    private String master;
    private String type;

    public Pet() {
    }

    public Pet(String name, String master, String type) {
        this.name = name;
        this.master = master;
        this.type = type;
    }

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

    /**
     *Функция возвращает класс животного (разумный для человека с именем, фамилией или не разумный, кличка и имя владельца)
     */

    @Override
    public String getHomeMemberType() {
        return "NoHuman";
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", master='" + master + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
