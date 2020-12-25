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
        User user = new User();
        user.setAccount("TEST_1");
        user.setPassword("123123");
        user.setStatus("REGISTERED");
        user.setEmail("TEST_1@gmail.com");
        user.setPhoneNumber("010-0000-0001");
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("AdminServer");

        User returnUser = userRepository.save(user);
        Assertions.assertNotNull(returnUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-0000-0001");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getRevAddress());
            System.out.println("------------------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("상태: " + orderDetail.getStatus());
                System.out.println("도착일자: " + orderDetail.getArrivalDate());
                System.out.println("상품이름: " + orderDetail.getItem().getName());
                System.out.println("고객센터: " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
            });
        });
        Assertions.assertNotNull(user);
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
