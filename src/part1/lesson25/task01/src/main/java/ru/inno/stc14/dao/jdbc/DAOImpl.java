package ru.inno.stc14.dao.jdbc;

import ru.inno.stc14.dao.DAO;
import ru.inno.stc14.entity.Animal;
import ru.inno.stc14.entity.Person;
import ru.inno.stc14.entity.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOImpl implements DAO {
    private static Logger logger = Logger.getLogger(DAOImpl.class.getName());
    private final Connection connection;

    public DAOImpl(Connection con) {
        this.connection = con;
    }

    private static final String INSERT_PERSON_SQL_TEMPLATE =
            "insert into person (name, birth_date,email,phone) values (?, ?, ?, ? )";
    private static final String INSERT_PET_SQL_TEMPLATE =
            "insert into pet (name, master,type) values (?, ?, ?)";
    private static final String SELECT_PERSON_SQL_TEMPLATE =
            "select id, name, birth_date,email,phone from person";
    private static final String SELECT_PET_SQL_TEMPLATE =
            "select id, name, master,type from pet";


    @Override
    public List<Person> getPersonList() {
        List<Person> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PERSON_SQL_TEMPLATE)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setBirthDate(resultSet.getString(3));
                    person.setEmail(resultSet.getString(4));
                    person.setPhone(resultSet.getString(5));
                    result.add(person);
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
        }
        return result;
    }


    @Override
    public List<Pet> getPetList() {
        List<Pet> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PET_SQL_TEMPLATE)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pet pet = new Pet();
                    pet.setId(resultSet.getInt(1));
                    pet.setName(resultSet.getString(2));
                    pet.setMaster(resultSet.getString(3));
                    pet.setType(resultSet.getString(4));
                    result.add(pet);
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
        }
        return result;
    }

    @Override
    public boolean addAnimal(Animal animal) {
        System.out.println("!!!!!!!!!!!!!!1" + animal.getAnimalType());
        if (animal.getAnimalType().compareTo("Human") == 0) {
            Person person = (Person) animal;
            System.out.println(person.toString());

            try (PreparedStatement statement = connection.prepareStatement(INSERT_PERSON_SQL_TEMPLATE)) {
                statement.setString(1, person.getName());
                statement.setString(2, person.getBirthDate());
                statement.setString(3, person.getEmail());
                statement.setString(4, person.getPhone());
                statement.execute();
                return true;
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
                return false;
            }
        }
        if (animal.getAnimalType().compareTo("NoHuman") == 0) {
            Pet pet = (Pet) animal;
            System.out.println(pet.toString());

            try (PreparedStatement statement = connection.prepareStatement(INSERT_PET_SQL_TEMPLATE)) {
                statement.setString(1, pet.getName());
                statement.setString(2, pet.getMaster());
                statement.setString(3, pet.getType());
                statement.execute();
                return true;
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
                return false;
            }
        }
        return false;

    }
}
