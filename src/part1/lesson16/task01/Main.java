package part1.lesson16.task01;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.*;

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
            log.info("Open connection ");
            Connection cn = ConnectionFactory.getDatabaseConnection();
            SqlOperations sqlTest = new SqlOperations(cn);
            log.trace("Зупуск функции вставки записи в БД");
            sqlTest.makeInsert();

            log.trace("Запуск функции параметрическая вставка записи в БД");
            sqlTest.makeParamInsert();

            log.trace("Запуск функции пакетной вставки записи в БД");
            sqlTest.makeBatchInsert();
            log.trace("Запуск функции параметрическая выборка из БД");
            sqlTest.makeParamSelect();
            log.trace("Запуск функции вставка и откат в точке сохранения");
            sqlTest.makeSaveTransaction();
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }


}
