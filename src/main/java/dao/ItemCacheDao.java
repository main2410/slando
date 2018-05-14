package dao;

import entity.Item;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemCacheDao extends Dao {

    private List<Item> items = null;
    private Timer timer = new Timer();

    public ItemCacheDao() {
        updateItemCache();
        timer.schedule(new CacheUpdater(), 20000, 20000);
    }

    private void updateItemCache() {
        Session s = openSessionAndBeginTransaction();
        items = s.createCriteria(Item.class).list();
        commitTransactionAndCloseSession(s);
        sort(items);
    }

    public List<Item> get() {
        return items;
    }

    public List<Item> getById(String id) {
        List<Item> out = new LinkedList<>();
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
        List<Item> out = new LinkedList<>();
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
        List<Item> out = new LinkedList<>();
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

    private void sort(List<Item> items) {
        Collections.sort(items, (item1, item2) ->
                item2.getCreateDate().compareTo(item1.getCreateDate()));
        List vip = new LinkedList();
        for (Item item : items) {
            if (item.getIsVip() && vip.size() < 2) {
                vip.add(item);
            }
        }
        items.removeAll(vip);
        items.addAll(0, vip);
    }
}
