package ru.inno.stc14.entity;

import java.util.Objects;

/**
 * Класс человек. Предназначен для хранения объекта с контактными данными
 */

public class Person implements HomeMember {
    private int id;
    private String name;
    private String birthDate;
    private String email;
    private String phone;

    public Person() {
    }

    public Person(String name, String birthDate, String email, String phone) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email=" + email +
                ", phone=" + phone +
                '}';
    }


    /**
     *Функция возвращает класс животного (разумный для человека с именем, фамилией или не разумный, кличка и имя владельца)
     */

    @Override
    public String getHomeMemberType() {
        return "Human";
    }
}
