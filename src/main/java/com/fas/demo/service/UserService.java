package com.fas.demo.service;

import com.fas.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUserList();

    Optional<User> findUserById(long id);

    void save(User user);

    void edit(User user);

    void delete(long id);


    Page<User> findList(Pageable pageable);
}
