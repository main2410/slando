package dao;

import entity.Item;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    public List<Item> getByNameOrCat(String q, String cat) {

        List<Item> items = new LinkedList<>();
        if (q.length() > 2) {
            for (Item item : get()) {
                if (item.getName().contains(q)) {
                    items.add(item);
                }
            }
        } else if (cat.length() > 0) {
            for (Item item : get()) {
                if (item.getCat().equals(cat)) {
                    items.add(item);
                }
            }
        }
        return items;
    }


    private List<Item> getDataByQuery(String query) {
        Session s = openSessionAndBeginTransaction();
        List<Item> out = s.createQuery(query).list();
        commitTransactionAndCloseSession(s);
        return out;
    }

}
