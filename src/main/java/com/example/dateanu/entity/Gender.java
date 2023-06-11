package com.example.dateanu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Gender {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "gender")
    private List<Client> clientList = new ArrayList<>();

    @OneToMany(mappedBy = "interestedGender",cascade = CascadeType.ALL)
    private List<InterestedGender> interestedGenderList = new ArrayList<>();

    @OneToMany(mappedBy = "interestedGenderClient",cascade = CascadeType.ALL)
    private List<InterestedGender> interestedGenderClientList = new ArrayList<>();
}
