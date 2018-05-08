package dao;

import entity.Item;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class ItemCacheDao  extends Dao {

    private List<Item> items = null;
    private Timer timer = new Timer();

    public ItemCacheDao() {
        updateItemCache();
        timer.schedule(new CacheUpdater(), 20000, 20000);
    }

    public void updateItemCache() {
        Session s = openSessionAndBeginTransaction();
        items = s.createCriteria(Item.class).list();
        commitTransactionAndCloseSession(s);
    }

    public List<Item> get() {
        return items;
    }

    public List<Item> getById(String id) {
        List<Item> out = new LinkedList<Item>();
        if (items != null && id != null) {
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    out.add(item);
                }
            }
        }
        return out;
    }

    public List<Item> getByNameOrCat(String q, String cat) {
        List<Item> out = new LinkedList<Item>();
        if (items != null && q != null && q.length() > 2) {
            for (Item item : items) {
                if (item.getName().contains(q)) {
                    out.add(item);
                }
            }
        } else if (items != null && cat != null && cat.length() > 0) {
            for (Item item : items) {
                if (item.getCat().equals(cat)) {
                    out.add(item);
                }
            }
        }
        return out;
    }

    public List<Item> getByOwner(String owner) {
        List<Item> out = new LinkedList<Item>();
        if (items != null && owner != null && owner.length() > 0) {
            for (Item item : items) {
                if (item.getOwner().equals(owner)) {
                    out.add(item);
                }
            }
        }
        return out;
    }

    public void add(Item i) {
        Session s = openSessionAndBeginTransaction();
        s.save(i);
        commitTransactionAndCloseSession(s);
    }

    public void update(Item i) {
        Session s = openSessionAndBeginTransaction();
        s.update(i);
        commitTransactionAndCloseSession(s);
    }

    public void delete(Item i) {
        Session s = openSessionAndBeginTransaction();
        s.delete(i);
        commitTransactionAndCloseSession(s);
    }

    class CacheUpdater extends TimerTask {

        @Override
        public void run() {
            updateItemCache();
        }

    }

}
