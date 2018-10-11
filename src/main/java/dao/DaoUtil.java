package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("daoUtil")
public class DaoUtil {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    private ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();


    public DaoUtil setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        return this;
    }

    public Session getSession(){
        Session session = sessionThreadLocal.get();
        if (null == session || !session.isOpen()){
            session = sessionFactory.openSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    public void closeSession(){
        Session session = sessionThreadLocal.get();
        sessionThreadLocal.set(null);
        if (null != session && session.isOpen()){
            session.close();
        }
    }

}
