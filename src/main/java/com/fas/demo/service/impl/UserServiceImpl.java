package com.fas.demo.service.impl;

import com.fas.demo.entity.User;
import com.fas.demo.repository.UserRepository;
import com.fas.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUserList() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findUserById(long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void edit(User user) {
        repository.save(user);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<User> findList(Pageable pageable) {
        Page<User> userPage = repository.findAll(pageable);
        List<User> users = userPage.getContent();
        return new PageImpl<User>(users, pageable, userPage.getTotalElements());
    }


}


