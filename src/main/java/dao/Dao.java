package dao;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
abstract class Dao {

    Session openSessionAndBeginTransaction() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        return s;
    }

    void commitTransactionAndCloseSession(Session s) {
        s.getTransaction().commit();
        s.close();
    }
}
