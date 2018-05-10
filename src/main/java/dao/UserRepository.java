package dao;

import entity.User;
import org.springframework.data.repository.CrudRepository;

//@Repository("slando_user")
public interface UserRepository extends CrudRepository<User, String> {
    User getUserByLogin(String login);
}
