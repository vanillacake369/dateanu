/*
package com.example.dateanu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
public class InterestedGender {
    @Id
    @GeneratedValue
    @Column(name = "")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="gender_id")
    private Gender interestedGender;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="client_id")
    private Gender interestedGenderClient;
}
*/
