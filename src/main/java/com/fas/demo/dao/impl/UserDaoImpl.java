package com.fas.demo.dao.impl;

import com.fas.demo.dao.UserDao;
import com.fas.demo.entity.UserEntity;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user 对象
     */
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName 用户名
     * @return 用户
     */
    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        return user;
    }

    /**
     * 更新对象
     *
     * @param user 对象
     */
    @Override
    public long updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if (result != null)
            return result.getModifiedCount();
//            return result.getN();
        else
            return 0;
    }

    /**
     * 删除对象
     *
     * @param id id
     */
    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, UserEntity.class);
    }
}
