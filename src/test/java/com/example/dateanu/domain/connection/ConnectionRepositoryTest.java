package com.example.dateanu.domain.connection;

import com.example.dateanu.domain.client.Client;
import com.example.dateanu.domain.client.ClientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConnectionRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Test
    @Transactional // 테스트 이후 롤백용
    @DisplayName("회원1과 회원2 간의 1 대 1 매칭을 시도합니다.")
    public void setConnectionTest() throws Exception {
        // GIVEN
        // 회원  B 정보
        String emailA = "hohojohn@email.com";
        String nameA = "John HOHO";
        String phoneNumA = "010-1234-5678";
        Long imgA = 1L;
        String studentIdA = "20181029";
        Boolean hasExcludeAcquaintanceA = true;
        // 회원  B 정보
        String emailB = "jeniffer@email.com";
        String nameB = "Jeniffer HU";
        String phoneNumB = "010-7979-2344";
        Long imgB = 2L;
        String studentIdB = "20201112";
        Boolean hasExcludeAcquaintanceB = true;
        Client clientA = createClient(emailA, nameA, imgA, studentIdA, hasExcludeAcquaintanceA);
        Client clientB = createClient(emailB, nameB, imgB, studentIdB, hasExcludeAcquaintanceB);

        // 회원 A,B 저장
        Client savedClientA = clientRepository.save(clientA);
        Client savedClientB = clientRepository.save(clientB);

        // 회원 A,B 간 매칭
        Connection connectionOfAandB = Connection.builder()
                .maleMatcher(savedClientA)
                .femaleMatcher(savedClientB)
                .build();

        // WHEN
        Connection savedConnectionOfAandB = connectionRepository.save(connectionOfAandB);

        // THEN
        assertThat(savedConnectionOfAandB.getMaleMatcher()).isEqualTo(savedClientA);
        assertThat(savedConnectionOfAandB.getFemaleMatcher()).isEqualTo(savedClientB);
    }

    private static Client createClient(String email, String name, Long img, String studentId, Boolean hasExcludeAcquaintance) {
        return Client.builder()
                .email(email)
                .name(name)
                .img(img)
                .studentId(studentId)
                .hasExcludeAcquaintance(hasExcludeAcquaintance)
                .build();
    }
}