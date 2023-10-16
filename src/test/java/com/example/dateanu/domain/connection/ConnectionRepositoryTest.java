package com.example.dateanu.domain.connection;

import com.example.dateanu.domain.client.ClientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConnectionRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Test
    @Transactional // 테스트 이후 롤백용
    @DisplayName("회원1과 회원2 간의 매칭을 시도합니다.")
    public void setConnectionTest() throws Exception{
        // given

        // when

        // then

    }
}