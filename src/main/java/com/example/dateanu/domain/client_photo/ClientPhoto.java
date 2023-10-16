//package com.example.dateanu.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//public class ClientPhoto {
//    @Id
//    @GeneratedValue
//    @Column(name = "photo_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="client_id",nullable = true)
//    private Client clientPhoto;
//
//    @Lob
//    private String link;
//
//    @Lob
//    private String details;
//
//    private LocalDateTime timeAdded;
//
//    private boolean active;
//}
