package com.example.dateanu.domain.chat;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.chat_file.ChatFile;
import com.example.dateanu.domain.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Chat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id_pk;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "send_client_id")
    private Client sender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "recv_client_id")
    private Client receiver;

    @OneToMany(mappedBy = "chat")
    private List<ChatFile> chatFiles;
}
