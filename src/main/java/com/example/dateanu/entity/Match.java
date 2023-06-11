package com.example.dateanu.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 매칭정보 DTO
 *
 * id
 * name
 * memo
 * createDate
 */
@Getter
@Setter
@Entity
public class Match {
    @Id // 기본키
    @GeneratedValue
    @Column(name = "match_id")
    private Long id;

    private LocalDateTime matchedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="matched_client_id",nullable = false)
    private Client matchedClient;


    private LocalDateTime timeJoined;

    @Nullable
    private LocalDateTime timeLeft;
}
