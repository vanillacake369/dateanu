package com.example.dateanu.domain.client;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional // 테스트 이후 롤백용
    @DisplayName("고객을 생성해서 저장하였을 때, 콘솔에 출력하여 저장된 고객 엔티티를 확인한다.")
    void saveClient() {
        // GIVEN
        String email = "hohojohn@email.com";
        String name = "John HOHO";
        String phoneNum = "010-1234-5678";
        Long img = 1L;
        String studentId = "20181029";
        Boolean hasExcludeAcquaintance = true;
        Client client = Client.builder()
                .email(email)
                .name(name)
                .img(img)
                .studentId(studentId)
                .hasExcludeAcquaintance(hasExcludeAcquaintance)
                .build();

        // WHEN
        Client savedClient = clientRepository.save(client);
        Client foundClient = clientRepository.findClientByStudentIdAndName(studentId, name);

        // THEN
        assertThat(savedClient).isEqualTo(foundClient);
    }
}