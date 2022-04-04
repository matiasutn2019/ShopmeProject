package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.*;

import com.shopme.admin.user.repository.IUserRepository;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole() {
        Role role = entityManager.find(Role.class, 1);
        User user1 = new User("john@gmail.com", "john2022", "John", "Doe");
        user1.addRole(role);
        User savedUser = userRepository.save(user1);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateUserWithTwoRoles() {
        User user2 = new User("anne@gmail.com", "anne2022", "Anne", "Lone");
        Role role1 = new Role(3);
        Role role2 = new Role(5);
        user2.addRole(role1);
        user2.addRole(role2);
        User savedUser = userRepository.save(user2);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testAllUsers() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        User user = userRepository.findById(7).get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        User user4 = userRepository.findById(7).get();
        user4.setEnabled(true);
        userRepository.save(user4);
    }
}
