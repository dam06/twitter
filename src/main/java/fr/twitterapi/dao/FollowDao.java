package fr.twitterapi.dao;

import fr.twitterapi.entity.Follow;
import fr.twitterapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowDao extends CrudRepository<Follow,Long> {
    List<Follow> findAllByFollowId(Long id);
}
