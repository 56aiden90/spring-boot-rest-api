package com.dasol.study.service.implementation;

import com.dasol.study.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceImpTest {

    @Autowired // In a unit test, beans can be only injected through properties.
    private UserServiceImp userServiceImp;

    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void reset() {
        this.userServiceImp.findAll().forEach(user -> {
            this.userServiceImp.delete(user.getId());
        });
    }

    @Test
    public void createTest() {
        User testUser = new User("testName", "testEmail");
        assertThat(this.userServiceImp.create(testUser)).isEqualTo(testUser.getId());
        assertThat(this.userServiceImp.findAll().size()).isEqualTo(1);
    }

}
