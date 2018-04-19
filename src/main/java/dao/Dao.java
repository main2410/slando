package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Dao {

    protected Session openSessionAndBeginTransaction() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        return s;
    }

    protected void commitTransactionAndCloseSession(Session s) {
        s.getTransaction().commit();
        s.close();
    }

    }
