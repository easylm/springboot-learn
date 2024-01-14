package org.example.thymeleaf.service.impl;

import org.example.thymeleaf.entity.User;
import org.example.thymeleaf.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String username, String password, HttpSession session) {
        User user = this.getUser();
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }

    @Override
    public User getUser() {
        return new User()
                .setName("admin")
                .setUserId(1L)
                .setRole("admin")
                .setUsername("admin")
                .setPassword("123456");
    }

    @Override
    public List<User> listUser() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new User()
                    .setName("admin" + i)
                    .setUserId((long) i)
                    .setUsername("admin" + i)
                    .setRole("normal")
                    .setPassword("1000" + i)
                    .setEnable(i % 2 == 0)
                    .setCreatedDate(new Date())
            );
        }
        return users;
    }
}
