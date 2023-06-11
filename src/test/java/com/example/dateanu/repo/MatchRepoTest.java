package com.example.dateanu.repo;

import com.example.dateanu.entity.Match;
import com.example.dateanu.repository.ClientRepository;
import com.example.dateanu.repository.MatchRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MatchRepoTest {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("match table INSERT test")
    void matchInsertTest(){
        // given
        Match match = new Match();
        match.setMatchedTime(LocalDateTime.now());
        match.setMatchedClient(clientRepository.getReferenceById((long) 1));
        this.matchRepository.save(match);

        // when
        Match matchRepositoryReferenceById = this.matchRepository.getReferenceById((long) 1);

        // then
        // 여기서 에러가 나오는 구만...
         Assertions.assertThat(matchRepositoryReferenceById).isInstanceOf(Match.class);

    }
}
