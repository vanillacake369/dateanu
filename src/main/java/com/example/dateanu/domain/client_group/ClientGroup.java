package com.example.dateanu.domain.client_group;

import com.example.dateanu.domain.client.Client;
import com.example.dateanu.domain.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "client_group")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClientGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
