package ru.inno.stc14.dao;

import java.sql.Connection;

/**
 * Применен паттерн мост. Отделен интерфейс к составному объекту от его реализации
 */


public interface ConnectionManager {
    Connection getConnection();
}
