package ru.inno.stc14.service;

import ru.inno.stc14.dao.DAO;
import ru.inno.stc14.dao.jdbc.DAOImpl;
import ru.inno.stc14.entity.AnimalFactory;
import ru.inno.stc14.entity.Person;
import ru.inno.stc14.entity.Pet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

public class AnimalServiceImpl implements AnimalService {
    private Logger logger = Logger.getLogger(AnimalServiceImpl.class.getName());
    private final DAO personDAO;
    AnimalFactory factory;

    public AnimalServiceImpl(Connection con) {

        personDAO = new DAOImpl(con);
        factory = new AnimalFactory();
    }

    @Override
    public List getPersonList() {
        return personDAO.getPersonList();
    }
    @Override
    public List getPetList() {
        return personDAO.getPetList();
    }

    @Override
    public boolean addPerson(String name, String birth, String email, String phone) throws IOException {
        Person person = (Person) factory.create("Human");
        person.setName(name);
        person.setBirthDate(birth);
        person.setEmail(email);
        person.setPhone(phone);
        return personDAO.addAnimal(person);
    }

    @Override
    public boolean addPet(String name, String master,String type) throws IOException {
        AnimalFactory factory = new AnimalFactory();
        Pet pet = (Pet) factory.create("NoHuman");
        pet.setName(name);
        pet.setMaster(master);
        pet.setType(type);
        return personDAO.addAnimal(pet);
    }
}
