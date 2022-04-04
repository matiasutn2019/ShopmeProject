package com.shopme.admin.user.service;

import com.shopme.admin.user.repository.IUserRepository;
import com.shopme.common.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

}
