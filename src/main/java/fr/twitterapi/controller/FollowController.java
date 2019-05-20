package fr.twitterapi.controller;

import fr.twitterapi.dao.FollowDao;
import fr.twitterapi.dao.UserDao;
import fr.twitterapi.entity.Follow;
import fr.twitterapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FollowDao followDao;

    @PostMapping
    @Transactional
    public void followUser(@RequestBody User followedUser) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!auth.isAuthenticated()) {
            return;
        }

        String authenticatedUsername = auth.getName();

        User authenticatedUser = userDao.findByUsername(authenticatedUsername);

        Follow follow = new Follow();
        follow.setUser(authenticatedUser);
        follow.setFollow(followedUser);
        follow.settCreate(new Date());

        followDao.save(follow);
    }
    @GetMapping("/followers")
    public List<Follow> getAllFollower() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedUsername = auth.getName();
        User authenticatedUser = userDao.findByUsername(authenticatedUsername);

        return followDao.findAllByFollowId(User.getId());
    }
    @GetMapping("/follows")
    public List<User> getAllFollow() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedUsername = auth.getName();
        User authenticatedUser = userDao.findByUsername(authenticatedUsername);
        List<User> follows = new ArrayList<>();
        for (Follow follow:
                User.getFollows()) {

            follows.add(userDao.findByUsername(follow.getUser().getUsername()));
        }

        return follows;
    }


}



