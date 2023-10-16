package com.example.dateanu.rest_api.service;

import com.example.dateanu.rest_api.User;
import com.example.dateanu.rest_api.UserDaoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoServiceTest {
    @Autowired
    private UserDaoService userDaoService;

    @Test
    @Order(1)
    void convertEntity(){
        // given
        User newUser = User.builder()
                .id(null)
                .name("Joseph")
                .joinDate(new Date())
                .password(null)
                .build();
        User existedUser = User.builder()
                .id(1)
                .name("Stella")
                .joinDate(new Date())
                .password(null)
                .build();

        // when
        User createUser = userDaoService.replace(null,newUser);
        User changeEntity = userDaoService.replace(1,existedUser);

        // then
        assertThat(createUser.getId().equals(4));
        assertThat(changeEntity.getId().equals(1));
        assertThat(changeEntity.getName().equals("Stella"));

        System.out.println("======== RESULT ========");
        System.out.println(createUser.toString());
        System.out.println(changeEntity.toString());
        System.out.println("======== LIST ========");
        System.out.println(userDaoService.users.toString());
    }

    @Test
    @Order(2)
    void updateEntity(){
        // given
        Date dateOfAlice = new UserDaoService().findOne(1).getJoinDate();
        User request = User.builder()
                .id(1)
                .name("Joseph")
                .joinDate(dateOfAlice)
                .password(null)
                .build();
        // when
        User updatedUser = userDaoService.update(1,request);

        // then
        assertThat(updatedUser.getId().equals(1));
        assertThat(updatedUser.getName().equals("Joseph"));
        assertThat(updatedUser.getJoinDate().equals(dateOfAlice));

        System.out.println("======== RESULT ========");
        System.out.println(updatedUser.toString());
        System.out.println("======== LIST ========");
        System.out.println(userDaoService.users.toString());

    }
}
