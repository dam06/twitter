package fr.twitterapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class User {

    private static Long id;
    private String username;
   @JsonIgnore
    private String password;
    private String pseudo;
    private String bio;
    private boolean active;
    private Date tCreate;
    public static List<Follow>follows;
    public List<Role>roles;
    public List<Follow>followwers;



    @OneToMany (fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.REMOVE)
    public static List<Follow> getFollows() {
        return follows;
    }

    public void setFollowsers(List<Follow> follows) {
        this.follows = follows;
    }



    @OneToMany (fetch = FetchType.LAZY,mappedBy = "follow",cascade = CascadeType.REMOVE)
    public List<Follow> getFollowers() {
        return followwers;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public static Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public String getPasswoard() {
        return password;
    }

    public String getPseudo() {
        return pseudo;
    }

    @OneToMany (fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.REMOVE)
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getBio() {
        return bio;
    }

    public boolean isActive() {
        return active;
    }

    public Date gettCreate() {
        return tCreate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswoard(String password) {
        this.password = password ;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void settCreate(Date tCreate) {
        this.tCreate = tCreate;
    }


}
