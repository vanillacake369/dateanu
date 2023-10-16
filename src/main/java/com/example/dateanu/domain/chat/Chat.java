package com.example.dateanu.domain.chat;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Chat extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_pk")
    private Long id_pk;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="send_client_id")
    Client sender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="recv_client_id")
    Client receiver;

    // send_at => createdTime , updatedTime
}
