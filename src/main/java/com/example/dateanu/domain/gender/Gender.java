package com.example.dateanu.domain.gender;
public enum Gender {
    MALE("남성"), FEMALE("여성");

    private final String genderKor;

    Gender(String genderKor) {
        this.genderKor = genderKor;
    }
}
/*
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

    private String genderName;

    @OneToMany(mappedBy = "gender")
    private List<Client> clientList = new ArrayList<>();

    @OneToMany(mappedBy = "interestedGender")
    private List<InterestedGender> interestedGenderList = new ArrayList<>();

    @OneToMany(mappedBy = "interestedGenderClient")
    private List<InterestedGender> interestedGenderClientList = new ArrayList<>();
}
*/
