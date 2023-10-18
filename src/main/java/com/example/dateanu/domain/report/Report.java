package com.example.dateanu.domain.report;

import com.example.dateanu.domain.client.Client;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "report")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "initiator_client_id")
    private Client initiatorClient;

    @ManyToOne
    @JoinColumn(name = "target_client_id")
    private Client targetClient;
}
