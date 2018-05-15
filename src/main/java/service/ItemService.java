package service;

import dao.ItemCacheDao;
import entity.Item;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemCacheDao itemCacheDao;

    public void addItem(String cat, String name, String about, Integer price, String pic, User u) {

        itemCacheDao.add(Item.builder().
                cat(cat).
                name(name).
                about(about).
                price(price).
                pic(pic).
                owner(u.getLogin()).
                city(u.getCity()).
                email(u.getEmail()).
                phone(u.getPhone()).
                isVip(false).
                createDate(new Timestamp(System.currentTimeMillis())).build());
    }

    public Item getItemById(String id) {
        Item item = new Item();
        List<Item> items = new LinkedList<>();
        if (id != null) {
            items = itemCacheDao.getById(id);
        }
        if (items.size() > 0) {
            item = items.get(0);
        }
        return item;
    }

    public void changeItem(Item item, String cat, String name, String about,
                           String pic, Integer price, String isVip, String top) {
        if (item != null) {
            if (cat != null) {
                item.setCat(cat);
            }
            if (name != null) {
                item.setName(name);
            }
            if (about != null) {
                item.setAbout(about);
            }
            if (pic != null) {
                item.setPic(pic);
            }
            if (price != null) {
                item.setPrice(price);
            }
            item.setIsVip(isVip != null && isVip.equals("true"));
            if (item.getIsVip() || top != null) item.setCreateDate(new Timestamp(System.currentTimeMillis()));
            itemCacheDao.update(item);
        }
    }

    public void deleteItem(Item item) {
        itemCacheDao.delete(item);
    }

}
