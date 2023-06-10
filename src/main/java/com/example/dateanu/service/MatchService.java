package com.example.dateanu.service;

import com.example.dateanu.entity.Match;
import com.example.dateanu.exception.DataNotFoundException;
import com.example.dateanu.repository.MatchRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MatchService {
    // 생성자 주입으로 DI
    private final MatchRepository matchRepository;

    public List<Match> getMatchAll(){
        return this.matchRepository.findAll();
    }
    public Match getMatch(Long id){
        try{
            Optional<Match> byId = this.matchRepository.findById(id);
            if(byId.isPresent()){
                return byId.get();
            }
        }catch(Exception e){
            throw new DataNotFoundException("match not found");
        }
        return null;
    }

}
