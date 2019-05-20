package fr.twitterapi.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Follow {

    private Long id;
    private User user;
    private User follow;
    private Date tCreate;

    public Follow() {
    }

    public Follow(User user, User follow) {
        this.user = user;
        this.follow = follow;
    }

    public Follow(Long id, User user, User follow, Date tCreate) {
        this.id = id;
        this.user = user;
        this.follow = follow;
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
 @ManyToOne (fetch = FetchType.LAZY)
 @JoinColumn(name = "userId",nullable =false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "followUserId",nullable =false)
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
}
