package ru.inno.stc14.entity;

import ru.inno.stc14.entity.Person;
import ru.inno.stc14.entity.Pet;

import java.io.IOException;
import java.util.List;

/**
 * Применен паттерн мост. Отделен интерфейс к составному объекту от его реализации
 */

public interface Home extends HomeMember {

    List<Person> getPersonList();
    List<Pet> getPetList();

    boolean add(HomeMember member);
    List<HomeMember> getList();

}
