package part1.lesson16.task01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс предназначен для log4j2 для записо в БД журнальных файлов
 */

public class ConnectionFactory {

    /**
     * Функция вызывается из конфигурации log4j2
     * @return - объект connection к БД
     * @throws SQLException
     */


    public static Connection getDatabaseConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/inno?user=sam&password=Gfhjkm";
        return DriverManager.getConnection(url);
    }
}
