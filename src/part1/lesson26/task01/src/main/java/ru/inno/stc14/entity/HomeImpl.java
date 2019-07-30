package ru.inno.stc14.entity;

import ru.inno.stc14.dao.DAO;
import ru.inno.stc14.dao.jdbc.DAOImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Применен паттерн составной объект.
 * Составной объект служит для расширения состава объектов включенных в приложение.
 * Объект унаследован от интерфейса Home который в свою очередь унаследован от интерфейса HomeMember.
 *
 */


public class HomeImpl implements Home {
    private Logger logger = Logger.getLogger(HomeImpl.class.getName());
    private final DAO DAO;

    public HomeImpl(Connection con) {
        DAO = new DAOImpl(con);
    }

    @Override
    public List getPersonList() {
        return DAO.getPersonList();
    }
    @Override
    public List getPetList() {
        return DAO.getPetList();
    }

    @Override
    public String getHomeMemberType(){
        return "";
    }

    @Override
    public boolean add(HomeMember member){
        return DAO.addHomeMember(member);
    }

    @Override
    public List<HomeMember> getList(){
        return DAO.getHomeMemberList();
    }
}
