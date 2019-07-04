package ru.inno.stc14.service;

import ru.inno.stc14.dao.PersonDAO;
import ru.inno.stc14.dao.jdbc.PersonDAOImpl;
import ru.inno.stc14.entity.Person;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Класс реализации для работы с объектами person и БД
 */
public class PersonServiceImpl implements PersonService {
    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private final PersonDAO personDAO;

    public PersonServiceImpl(Connection con) {
        personDAO = new PersonDAOImpl(con);
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }


    @Override
    public boolean addPerson(String name, String birth,String password) throws IOException {
        if ("Feofan".equals(name)) {
            throw new IOException("Feofan is not available!");
        }
        Person person = new Person();
        person.setName(name);
        person.setBirthDate(birth);
        person.setPassword(password);

        return personDAO.addPerson(person);
    }

    /**
     * Функция провверки есть ли пользователь в БД. Используется для аутентификации
     * @param name - логин пользователя
     * @param password - пароль
     * @return
     * @throws IOException
     */
    @Override
    public boolean checkPerson(String name,String password) throws IOException {
        if ("Feofan".equals(name)) {
            throw new IOException("Feofan is not available!");
        }
        List<Person> persons = this.getList();
        Iterator<Person> it = persons.iterator();
        while (it.hasNext()){
            Person person = (Person) it.next();
            System.out.println(person.getName());
            if((name.compareTo(person.getName())==0) && (password.compareTo(person.getPassword())==0)){
                return true;
            }

        }
        return false;
    }

}
