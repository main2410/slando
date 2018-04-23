package service;

import dao.ItemDao;
import entity.Item;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public void addItem(String cat, String name, String about, Integer price, String pic, User u) {

        itemDao.add(Item.builder().
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


}
