package part1.lesson16.task01;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;

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
    private static Logger log = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/inno?user=sam&password=Gfhjkm";
            log.info("Open connection "+ url );
            Connection cn = DriverManager.getConnection(url);
            SqlOperations sqlTest = new SqlOperations(cn);
            log.info("Вставка записи в БД");
            sqlTest.makeInsert();

            log.info("Параметрическая вставка записи в БД");
            sqlTest.makeParamInsert();

            log.info("Пакетная вставка записи в БД");
            sqlTest.makeBatchInsert();
            log.info("Параметрическая выборка из БД");
            sqlTest.makeParamSelect();
            log.info("Вставка и откат в точке сохранения");
            sqlTest.makeSaveTransaction();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            //ex.printStackTrace();
        }
    }


}
