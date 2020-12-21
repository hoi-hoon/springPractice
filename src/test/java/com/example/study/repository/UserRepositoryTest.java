package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into  user (~~~) value (~~);
        User user = new User();
        user.setAccount("testUser2");
        user.setEmail("test2@mail.com");
        user.setPhoneNumber("010-02-012");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User returnUser = userRepository.save(user);
        System.out.println("returned :" + returnUser);
    }

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findByAccount("testUser2");

        user.ifPresent(selectUser ->{

            selectUser.getOrderDetailList().stream().forEach(detail->{
                System.out.println(detail.getItem());
            });
        });

    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("update");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("inspector");

            userRepository.save(selectUser);

        });
    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assertions.assertFalse(deleteUser.isPresent());
    }
}
