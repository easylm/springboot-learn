package org.example.mongodb.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mongodb.entity.User;
import org.example.mongodb.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final MongoTemplate mongoTemplate;

    /**
     * 添加用户
     *
     * @param user 用户数据
     */
    @Override
    public void insertUser(User user) {
        mongoTemplate.insert(user);
    }

    /**
     * 批量添加用户
     *
     * @param users 用户数据
     */
    @Override
    public void insertUser(List<User> users) {
        mongoTemplate.insert(users, User.class);
    }

    /**
     * 更新用户
     *
     * @param user 用户数据
     */
    @Override
    public void updateUser(User user) {
        Query eq = Query.query(Criteria.where("userId").is(user.getUserId()));
        Update username = new Update().set("username", user.getUserName()).set("sex", user.getSex());
        mongoTemplate.updateMulti(eq, username, User.class);

    }

    /**
     * 查询用户
     *
     * @param user 用户数据
     * @return list
     */
    @Override
    public List<User> listUser(User user) {
        return null;
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     */
    @Override
    public void deleteUser(Long userId) {

    }
}
