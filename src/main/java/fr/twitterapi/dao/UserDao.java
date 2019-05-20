package fr.twitterapi.dao;

import fr.twitterapi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    User findByUsername(String authentificationUsername);
}
