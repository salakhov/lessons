package part1.lesson15.task01;

import java.sql.*;

/**
 * ДЗ_13
 * 1)DONE   Спроектировать базу*
 * -      Таблица USER содержит поля id, name, birthday, login_ID, city, email, description
 * -      Таблица ROLE содержит поля id, name (принимает значения Administration, Clients, Billing), description
 * -      Таблица USER_ROLE содержит поля id, user_id, role_id
 * Типы полей на ваше усмотрению, возможно использование VARCHAR(255)
 * 2) DONE Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
 *          a)  DONE    Используя параметризированный запрос
 *          b)  DONE    Используя batch процесс
 * 3) DONE     Сделать параметризированную выборку по login_ID и name одновременно
 * 4) DONE     Перевести connection в ручное управление транзакциями
 *          a)  DONE    Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
 *                  между sql операциями установить логическую точку сохранения(SAVEPOINT)
 *          б)  DONE  Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
 *              между sql операциями установить точку сохранения (SAVEPOINT A),
 *              намеренно ввести некорректные данные на последней операции,
 *              что бы транзакция откатилась к логической точке SAVEPOINT A
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
