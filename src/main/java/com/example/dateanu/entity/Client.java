package com.example.dateanu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String first_name;
    
    private String last_name;
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="gender_id")
    private Gender gender;

    private String email;

    private String password;

    private LocalDateTime clientCreatedTime;

    @OneToMany(mappedBy = "matchedClient", cascade = CascadeType.ALL)
    private List<Match> matches;

    @OneToMany(mappedBy = "conversationClient", cascade = CascadeType.ALL)
    private List<Conversation> conversations;

    @OneToMany(mappedBy = "clientPhotoId",cascade = CascadeType.ALL)
    private List<ClientPhoto> photos;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "client_hobby")
    private Hobby clientHobby;
}