package fr.twitterapi.dao;
import fr.twitterapi.entity.Role;
import fr.twitterapi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,Long> {
}
