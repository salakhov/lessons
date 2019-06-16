package part1.lesson16.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.*;

/**
 * Класс для демонстрации решения ДЗ
 * Класс предназначен для выполнения операций с БД
 *   makeInsert() - функция вставки статического INSERT
 *   makeBatchInsert() - функция пакетной вставки
 *   makeParamInsert() - функция заполнения параметров INSERT
 *   makeParamSelect() - функция осуществляет параметризованную выборку
 *   makeSaveTransaction() - функция осуществляет рабоу с точками сохранения
 */

public class SqlOperations {
    private Connection connection;
    private static Logger log = (Logger) LogManager.getLogger(SqlOperations.class);

    public SqlOperations(Connection connection) {
        this.connection = connection;
    }

    /**
     * Функция  вставки в таблицу через jdbc интерфейс
     * @throws SQLException
     */
    public void makeInsert() throws SQLException {
        String SQL_INSERT =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (2, 'Archibald Arnold Arnoldovich', '2014-04-04', 'archibald'," +
                        " 'Tver', 'archibald@mail.ru','Человек');";

        String SQL_INSERT1 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (3, 'Annohin Annog Isinbaevich', '2014-04-04', 'annohin', 'Tver', 'annohin@mail.ru','Человек');";

        PreparedStatement ps = null;
        ps = this.connection.prepareStatement(SQL_INSERT);
        ps.executeUpdate();
        ps = this.connection.prepareStatement(SQL_INSERT1);
        ps.executeUpdate();
        log.info("Функция  вставки в таблицу через jdbc интерфейс выполнена успешно");
    }

    /**
     * Функция  вставки в таблицу через jdbc интерфейс используя batch процесс
     * @throws SQLException
     */
    public void makeBatchInsert() throws SQLException{

        String SQL_INSERT_BATCH1 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (4, 'Batchibald Batch Onde', '2014-04-04', 'batch1', 'Tver', 'batch1@mail.ru','Человек');";

        String SQL_INSERT_BATCH2 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (5, 'Batchibald Batch Two', '2014-04-04', 'batch2', 'Tver', 'batch2@mail.ru','Человек');";

        Statement st = this.connection.createStatement();
        this.connection.setAutoCommit(false);
        st.addBatch(SQL_INSERT_BATCH1);
        st.addBatch(SQL_INSERT_BATCH2);
        st.executeBatch();
        this.connection.commit();
        log.info("Функция  вставки в таблицу через jdbc интерфейс используя batch процесс выполнена успешно");
    }

    /**
     *  Функция  вставки в таблицу через jdbc интерфейс Используя параметризированный запрос
     * @throws SQLException
     */
    public void makeParamInsert() throws SQLException {

        String SQL_INSERT_PARAM =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        Date date = new Date(100000);
        ps = this.connection.prepareStatement(SQL_INSERT_PARAM);
        ps.setInt(1, 11);
        ps.setString(2, "Ivanov Ivan Ivanivich");
        ps.setDate(3, date);
        ps.setString(4, "ivanov");
        ps.setString(5, "Tver");
        ps.setString(6, "ivanov@mail.ru");
        ps.setString(7, "Human");
        ps.executeUpdate();
        log.info("Функция  вставки в таблицу через jdbc интерфейс Используя параметризированный запрос выполнена успешно");
    }

    /**
     * Функция выполняет параметризированную выборку по login_ID и name одновременно
     * @throws SQLException
     */
    public void makeParamSelect() throws SQLException{

        String SQL_SELECT =
                "SELECT name,loginId FROM USERS";

        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(SQL_SELECT);
        while(rs.next()){
            System.out.println("login: "+rs.getString(2)+
                    " ssername: " +rs.getString(1));
        }
        log.info("Функция параметризированной выборки по login_ID и name одновременно выполнена успешно");
    }

    /**
     * Функция выполняет работу с точками сохранения и осуществляет выполнение и откат к точке SAVPOINTB
     * @throws SQLException
     */

    public void makeSaveTransaction() throws SQLException{

        String SQL_INSERT_SAVE1 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (6, 'SavepointA Savepointovicha Savepointov', '2014-04-04', 'savepointA', 'Tver', 'savepointA@mail.ru','Человек');";
        String SQL_INSERT_SAVE1_ROLES =
                "INSERT INTO roles(id, name) " +
                        "VALUES (1, 'Administration');";
        String SQL_INSERT_SAVE1_USER_ROLES =
                "INSERT INTO user_role (id, user_id, role_id) " +
                        "VALUES (1, 4, 1);";

        String SQL_INSERT_SAVE2 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (7, 'SavepointB Savepointovicha Savepointov', '2014-04-04', 'savepointB', 'Tver', 'savepointB@mail.ru','Человек');";

        String SQL_DELETE_USERS = "DELETE FROM USERS";
        String SQL_DELETE_ROLES = "DELETE FROM ROLES";
        String SQL_DELETE_USER_ROLES = "DELETE FROM user_role";

        this.connection.setAutoCommit(false);

        //заполняем БД консистемными данными в пользователь и его роль. Ценная работа
        PreparedStatement ps = this.connection.prepareStatement(SQL_INSERT_SAVE1);
        ps.executeUpdate();
        ps = this.connection.prepareStatement(SQL_INSERT_SAVE1_ROLES);
        ps.executeUpdate();
        ps = this.connection.prepareStatement(SQL_INSERT_SAVE1_USER_ROLES);
        ps.executeUpdate();

        Savepoint sp1 = this.connection.setSavepoint("SAVEPOINTA");

        //Еще один INSERT
        ps = this.connection.prepareStatement(SQL_INSERT_SAVE2);
        ps.executeUpdate();

        Savepoint sp2 = this.connection.setSavepoint("SAVEPOINTB");
        //Случаной удалям ценную работу
        ps = this.connection.prepareStatement(SQL_DELETE_USER_ROLES);
        ps.executeUpdate();
        ps = this.connection.prepareStatement(SQL_DELETE_ROLES);
        ps.executeUpdate();
        ps = this.connection.prepareStatement(SQL_DELETE_USERS);
        ps.executeUpdate();

        //Откатываемся
        this.connection.rollback(sp1);
        //Комитим
        this.connection.commit();
        this.connection.setAutoCommit(true);

        log.info(" Функция демонстрации работы с точками сохранения и осуществляет выполнение и откат к точке SAVPOINTB выполнена успешно");
    }
}
