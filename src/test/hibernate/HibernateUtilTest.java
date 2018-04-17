package hibernate;

import entity.User;
import org.hibernate.Session;


public class HibernateUtilTest {

    @org.junit.Test
    public void getSessionFactory() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        User u = User.builder().login("test").pass("test1").build();
        s.save(u);
        s.getTransaction().commit();
        s.close();
    }
}