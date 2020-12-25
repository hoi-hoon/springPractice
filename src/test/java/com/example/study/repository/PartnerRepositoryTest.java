package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends StudyApplicationTests {
    @Autowired
    PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = new Partner();
        partner.setName("Partner_1");
        partner.setStatus("REGISTERED");
        partner.setAddress("서울시 성북구 성북동");
        partner.setCallCenter("010-0000-0002");
        partner.setBusinessNumber("1234");
        partner.setCeoName("이순신");
        partner.setRegisteredAt(LocalDateTime.now());
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("AdminServer");
        // partner.setCategoryId(1L);
        Partner returnPartner = partnerRepository.save(partner);

        Assertions.assertNotNull(returnPartner);
        Assertions.assertEquals(returnPartner.getName(),partner.getName());
    }

    @Test
    public void read(){

    }
}
