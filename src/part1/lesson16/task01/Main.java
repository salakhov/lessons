package part1.lesson16.task01;

import org.apache.logging.log4j.core.Logger;

import java.sql.*;
import java.util.logging.LogManager;

/**
 * ДЗ_16
 Взять за основу ДЗ_13,

 покрыть код логированием

 в основных блоках try покрыть уровнем INFO

 с исключениях catch покрыть уровнем ERROR

 настроить конфигурацию логера, что бы все логи записывались в БД, таблица LOGS,

 колонки ID, DATE, LOG_LEVEL, MESSAGE, EXCEPTION
 */

public class Main {

    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/inno?user=sam&password=Gfhjkm";

            Connection cn = DriverManager.getConnection(url);
            SqlOperations sqlTest = new SqlOperations(cn);
            sqlTest.makeInsert();
            sqlTest.makeParamInsert();
            sqlTest.makeBatchInsert();
            sqlTest.makeParamSelect();
            sqlTest.makeSaveTransaction();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
