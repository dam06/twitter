package fr.twitterapi.dao;
import fr.twitterapi.entity.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface TweetDao  extends CrudRepository<Tweet,Long> {
    List<Tweet> findAllByUserId(Long id, Pageable pageable);
    List<Tweet> findAllByUserFollows(Long id, Pageable pageable);
}






