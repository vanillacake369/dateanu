package com.example.dateanu.service;

import com.example.dateanu.entity.Match;
import com.example.dateanu.repository.ClientRepository;
import com.example.dateanu.repository.MatchRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatchServiceTest {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional
    void getMatchAll() {
        // given
        Match match = new Match();
        match.setMatchedTime(LocalDateTime.now());
        match.setMatchedClient(clientRepository.getReferenceById((long) 1));
        this.matchRepository.save(match);

        // when
        MatchService service = new MatchService(matchRepository);

        // then
        List<Match> matchList = service.getMatchAll();
        System.out.println(matchList.toString());
    }
}