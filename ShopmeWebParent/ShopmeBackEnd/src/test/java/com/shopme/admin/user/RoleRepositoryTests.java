package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.*;

import com.shopme.admin.user.repository.IRoleRepository;
import com.shopme.common.entity.Role;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(value = false)
public class RoleRepositoryTests {

    @Autowired
    private IRoleRepository roleRepository;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = roleRepository.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles() {
        Role roleSalesperson = new Role("Salesperson", "manage product price, "
                + "customers, shipping, orders and sales report");

        Role roleEditor = new Role("Editor", "manage categories, brands, "
                + "products, articles and menus");

        Role roleShipper = new Role("Shipper", "view products, view orders "
                + "and update order status");

        Role roleAssistant = new Role("Assistant", "manage questions and reviews");

        roleRepository.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));

        assertThat(roleSalesperson.getId()).isGreaterThan(0);
        assertThat(roleEditor.getId()).isGreaterThan(0);
        assertThat(roleShipper.getId()).isGreaterThan(0);
        assertThat(roleAssistant.getId()).isGreaterThan(0);
    }

}
