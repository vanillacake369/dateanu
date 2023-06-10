package com.example.dateanu.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    private Long matchApplyUserId;

    private Long matchedUserId;

    private LocalDateTime matchedTime;

    @ManyToOne
    @JoinColumn(name="match_id",nullable = false)
    private Client matchedClient;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", matchApplyUserId=" + matchApplyUserId +
                ", matchedUserId=" + matchedUserId +
                ", matchedTime=" + matchedTime +
                ", matchedClient=" + matchedClient +
                '}';
    }
}
