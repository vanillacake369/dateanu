package com.example.dateanu.domain.chat_file;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.chat.Chat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "chat_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatFile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;


}
