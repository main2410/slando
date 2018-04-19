package dao;

import entity.Item;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;

public class ItemDao extends Dao{

    public List<Item> get(){
        return getDataByQuery("SELECT * FROM slando_item");
    }
   
    public List<Item> getById(String id){
        return getDataByQuery("SELECT * FROM slando_item WHERE id=" + id);
    }
   
    public void add(Item i){
        Session s = openSessionAndBeginTransaction();
        s.save(i);
        commitTransactionAndCloseSession(s);
    }
   
}
