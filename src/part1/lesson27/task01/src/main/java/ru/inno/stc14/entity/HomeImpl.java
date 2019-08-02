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
 *
 * При применение паттерна наблюдатель содержит объекты которые необходимо уведомлять
 */


public class HomeImpl implements Home {
    private Logger logger = Logger.getLogger(HomeImpl.class.getName());
    private final DAO DAO;
    private Jkx jkx1,jkx2,jkx3;

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

    /**
     * При добавлении жителя созданные объектаы класса JKX получают уведомления
     * Уведомления сохраняются в БД для последующего отображения на экране
     * @param member
     * @return
     */
    @Override
    public boolean add(HomeMember member){
        Notification notification = new Notification();
        jkx1 = new Jkx("JKX1",notification);
        jkx2 = new Jkx("JKX2",notification);
        jkx3 = new Jkx("JKX3",notification);
        notification.create("Added new homemember" + member.toString() );
        System.out.println(notification.getContent());

        DAO.saveNotification(notification.getContent());

        return DAO.addHomeMember(member);
    }

    @Override
    public List<HomeMember> getList(){
        return DAO.getHomeMemberList();
    }
    public List<Message> getNotifications(){
        return DAO.getNotificationList();
    }


}
