package com.example.dateanu.controller;

import com.example.dateanu.entity.Match;
import com.example.dateanu.repository.MatchRepository;
import com.example.dateanu.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/match")
@RequiredArgsConstructor
@Controller
public class MatchController {
    private final MatchRepository matchRepository;
    private final MatchService matchService;

    @GetMapping( value="/list")
    public String match(Model model) {
        List<Match> matchList = this.matchService.getMatchAll();
        model.addAttribute("matchList", matchList); // 타임리프 모델
        return "match_list"; // return to Spring MVC framework and MVC look for thymeleaf named "match_list.html"
    }

    @GetMapping(value="/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Match match = this.matchService.getMatch(id);
        model.addAttribute("match", match);
        return "match_detail"; // return to Spring MVC framework and MVC look for thymeleaf named "match_list.html"
    }
}
