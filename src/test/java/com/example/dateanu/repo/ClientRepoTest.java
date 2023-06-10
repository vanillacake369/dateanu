package com.example.dateanu.repo;

import com.example.dateanu.entity.Client;
import com.example.dateanu.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ClientRepoTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional
    @DisplayName("user table INSERT test")
    void clientInsertTest(){
        // given
        Client clientA = new Client();
        clientA.setName("홍길동");
        clientA.setEmail("gildong@naver.com");
        clientA.setPassword("2iwEHkdl");
        clientA.setClientCreatedTime(LocalDateTime.now());
        this.clientRepository.save(clientA);

        Client clientB = new Client();
        clientB.setName("김고은");
        clientB.setEmail("goeun130@naver.com");
        clientB.setPassword("slaiSDLIN");
        clientB.setClientCreatedTime(LocalDateTime.now());
        this.clientRepository.save(clientB);

        // when
        Client firstClient = this.clientRepository.getReferenceById((long)1);
        Client secondClient = this.clientRepository.getReferenceById((long)2);

        // then
        // 여기서 에러가 나오는 구만...
        Assertions.assertThat(firstClient).isInstanceOf(Client.class);
        System.out.println("firstClient : "+firstClient);
        Assertions.assertThat(secondClient).isInstanceOf(Client.class);
        System.out.println("secondClient : "+secondClient);
    }
}
