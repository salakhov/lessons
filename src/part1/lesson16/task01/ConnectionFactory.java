package part1.lesson16.task01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    public static Connection getDatabaseConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/inno?user=sam&password=Gfhjkm";
        return DriverManager.getConnection(url);
    }
}
