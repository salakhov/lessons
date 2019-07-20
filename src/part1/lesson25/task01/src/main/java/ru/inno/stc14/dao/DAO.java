package ru.inno.stc14.dao;

import ru.inno.stc14.entity.Animal;
import ru.inno.stc14.entity.Person;
import ru.inno.stc14.entity.Pet;

import java.util.List;

public interface DAO {

    List<Pet> getPetList();
    List<Person> getPersonList();

    boolean addAnimal(Animal animal);
}
