package ru.inno.stc14.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Добавлены поля в соответствии с заданием
 * email,phone
 */

public class Person {
    private int id;
    private String name;
    private String birthDate;
    private String email;
    private String phone;

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

    /** Добавлен email
     *
     * @param email
     */

    public void setEmail(String email) { this.email = email; }

    /**
     * Добавлен телефон
     * @return
     */

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
}
