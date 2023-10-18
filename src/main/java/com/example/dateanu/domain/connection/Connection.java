package com.example.dateanu.domain.connection;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "connection")
public class Connection extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "male_client_id")
    private Client maleMatcher;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "female_client_id")
    private Client femaleMatcher;

    @Builder
    private Connection(Long id, Client maleMatcher, Client femaleMatcher) {
        this.id = id;
        this.maleMatcher = maleMatcher;
        this.femaleMatcher = femaleMatcher;
    }
}
