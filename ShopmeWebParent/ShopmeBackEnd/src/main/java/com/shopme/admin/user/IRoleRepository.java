package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {

}
