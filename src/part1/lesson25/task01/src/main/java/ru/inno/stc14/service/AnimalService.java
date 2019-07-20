package ru.inno.stc14.service;

import ru.inno.stc14.entity.Person;
import ru.inno.stc14.entity.Pet;

import java.io.IOException;
import java.util.List;

public interface AnimalService {

    List<Person> getPersonList();
    List<Pet> getPetList();

    boolean addPerson(String name, String birth, String email, String phone)  throws IOException;
    boolean addPet(String name, String master, String type)  throws IOException;
}
