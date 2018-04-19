package hibernate;

import entity.User;
import org.hibernate.Session;
import org.junit.Test;


public class HibernateUtilTest {

    @Test
    public void getSessionFactory() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        User u = User.builder().login("test").pass("test1").build();
        s.save(u);
        s.getTransaction().commit();
        s.close();
    }
}