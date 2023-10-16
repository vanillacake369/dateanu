//package com.example.dateanu.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class Hobby {
//
//    @Id
//    @GeneratedValue
//    @Column(name="hobby_id")
//    private Long id;
//
//    private String hobbyName;
//
//    @OneToMany(mappedBy = "clientHobby")
//    private List<Client> clientList = new ArrayList<>();
//}
