package dao;

import entity.Item;
import org.hibernate.Session;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemDao extends Dao {

    public List<Item> get() {
        Session s = openSessionAndBeginTransaction();
        List<Item> out = s.createCriteria(Item.class).list();
        commitTransactionAndCloseSession(s);
        return out;
    }

    public List<Item> getById(String id) {
        return getDataByQuery("SELECT * FROM slando_item WHERE id=" + id);
    }

    public void add(Item i) {
        Session s = openSessionAndBeginTransaction();
        s.save(i);
        commitTransactionAndCloseSession(s);
    }
    
    private List<Item> getDataByQuery(String query) {
        Session s = openSessionAndBeginTransaction();
        List<Item> out = s.createQuery(query).list();
        commitTransactionAndCloseSession(s);
        return out;
    }

}
