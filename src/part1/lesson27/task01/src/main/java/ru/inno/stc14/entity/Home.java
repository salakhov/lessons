package ru.inno.stc14.entity;

import java.util.List;

/**
 * Применен паттерн мост. Отделен интерфейс к составному объекту от его реализации
 */

public interface Home extends HomeMember {

    List<Person> getPersonList();
    List<Pet> getPetList();

    boolean add(HomeMember member);
    List<HomeMember> getList();
    List<Message> getNotifications();

}
