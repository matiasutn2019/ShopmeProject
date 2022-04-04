package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {

}
