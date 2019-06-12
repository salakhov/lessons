package part1.lesson15.task01;

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
            System.out.println(rs.getString(2)+" " +rs.getString(1));
        }
    }

    /**
     * Функция выполняет работу с точками сохранения и осуществляет выполнение и откат к точке SAVPOINTB
     * @throws SQLException
     */

    public void makeSaveTransaction() throws SQLException{
        String SQL_INSERT_SAVE1 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (6, 'SavepointA Savepointovicha Savepointov', '2014-04-04', 'savepointA', 'Tver', 'savepointA@mail.ru','Человек');";
        String SQL_INSERT_SAVE2 =
                "INSERT INTO users(id, name, birthday, loginId, city, email, description) " +
                        "VALUES (7, 'SavepointB Savepointovicha Savepointov', '2014-04-04', 'savepointB', 'Tver', 'savepointB@mail.ru','Человек');";
        String SQL_DELETE = "DELETE FROM USERS";

        this.connection.setAutoCommit(false);
        PreparedStatement ps = this.connection.prepareStatement(SQL_INSERT_SAVE1);
        ps.executeUpdate();
        Savepoint sp1 = this.connection.setSavepoint("SAVEPOINTA");
        ps = this.connection.prepareStatement(SQL_INSERT_SAVE2);
        ps.executeUpdate();
        Savepoint sp2 = this.connection.setSavepoint("SAVEPOINTB");
        ps = this.connection.prepareStatement(SQL_DELETE);
        ps.executeUpdate();
        this.connection.rollback(sp1);
        this.connection.commit();
    }
}
