package com.fas.demo.dao;

import com.fas.demo.entity.UserEntity;

public interface UserDao {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public long updateUser(UserEntity user);

    public void deleteUserById(Long id);

}
