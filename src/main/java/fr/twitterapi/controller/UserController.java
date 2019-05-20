package fr.twitterapi.controller;

import fr.twitterapi.UserCreationRequest;
import fr.twitterapi.dao.RoleDao;
import fr.twitterapi.dao.UserDao;
import fr.twitterapi.entity.Role;
import fr.twitterapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder BCryptPasswordEncoder;


    @GetMapping
    public Iterable<User> getALLUser() {
        return userDao.findAll();
    }


    @PostMapping
    @Transactional
    public void createUser(@RequestBody UserCreationRequest UserCreationRequest) {
        User user = new User();
        user.setUsername(UserCreationRequest.getUsername());
        user.setPasswoard(BCryptPasswordEncoder.encode(user.getPasswoard()));
        user.setActive(true);
        user.settCreate(new Date());
         userDao.save(user);

         Role role = new Role();
         role.setRole("ROLE_USER");
         role.setUser(user);
         roleDao.save(role);


    }


    @GetMapping("{userId}")
    public User getUser(@PathVariable("Userid") Long Userid) {
        return userDao.findById(Userid).orElse(null);
    }


}
