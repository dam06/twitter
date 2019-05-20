package fr.twitterapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Tweet {
    private User user;
    private User follow;
    private Date tCreate;
    private Long id;

    public Tweet(Long id, User user, User follow, Date tCreate) {
        this.id = id;
        this.user = user;
        this.follow = follow;
        this.tCreate = tCreate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollow() {
        return follow;
    }

    public void setFollow(User follow) {
        this.follow = follow;
    }

    public Date gettCreate() {
        return tCreate;
    }

    public void settCreate(Date tCreate) {
        this.tCreate = tCreate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
