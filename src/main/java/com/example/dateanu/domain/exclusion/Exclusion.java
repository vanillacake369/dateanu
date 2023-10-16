package com.example.dateanu.domain.exclusion;

import com.example.dateanu.domain.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "exclusion")
public class Exclusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="initiator_client_id")
    Client excludeInitClient;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="target_client_id")
    Client excludeTargetClient;

    // excluded_at => createdTime , updatedTime
}
