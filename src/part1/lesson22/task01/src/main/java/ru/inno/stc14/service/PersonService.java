package ru.inno.stc14.service;

import ru.inno.stc14.entity.Person;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс для сервиса person
 */
public interface PersonService {

    List<Person> getList();

    boolean addPerson(String name, String birth, String password) throws IOException;
    boolean checkPerson(String name,String password) throws IOException;
}
