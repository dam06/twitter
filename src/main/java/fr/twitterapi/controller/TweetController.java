package fr.twitterapi.controller;

import fr.twitterapi.dao.TweetDao;
import fr.twitterapi.dao.UserDao;
import fr.twitterapi.entity.Tweet;
import fr.twitterapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public class TweetController {


        @Autowired
        private TweetDao tweetDao;

        @Autowired
        private UserDao userDao;
    @PostMapping
        public Tweet createTweet(Tweet tweet) {
            tweet.settCreate(new Date());
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String authenticatedUsername = auth.getName();
            User user = userDao.findByUsername(authenticatedUsername);
            tweet.setUser(user);
            tweetDao.save(tweet);
            return tweet;
        }
    @GetMapping
        public List<Tweet> getAllTweetForConnectedUser(){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String authenticatedUsername = auth.getName();

            User authenticatedUser = userDao.findByUsername(authenticatedUsername);
            return tweetDao.findAllByUserId((long) authenticatedUser.getId(), (Pageable) PageRequest.of(0, 1));
        }
    @GetMapping
        public List<Tweet> getAllTweetForUserFollower() {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String authenticatedUsername = auth.getName();
            User authenticatedUser = userDao.findByUsername(authenticatedUsername);;
            return tweetDao.findAllByUserFollows((long) authenticatedUser.getId(), (Pageable) PageRequest.of(0, 1));
        }
    }

