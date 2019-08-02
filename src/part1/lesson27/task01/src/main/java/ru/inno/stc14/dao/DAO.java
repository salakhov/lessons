package ru.inno.stc14.dao;

import ru.inno.stc14.entity.*;

import java.util.List;

/**
 * Применен паттерн мост. Отделен интерфейс к составному объекту от его реализации
 */

public interface DAO {

    List<Pet> getPetList();
    List<Person> getPersonList();

    List<HomeMember> getHomeMemberList();

    boolean addHomeMember(HomeMember homeMember);
    List<Message> getNotificationList();
    boolean saveNotification(String message);
}
