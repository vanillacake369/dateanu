//package com.example.dateanu.entity;
//
//import jakarta.annotation.Nullable;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class Conversation {
//    @Id
//    @GeneratedValue
//    @Column(name = "conversation_id")
//    private Long id;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="conversation_matched_client_id",nullable = false)
//    private Client conversationClient;
//
//    private LocalDateTime timeStarted;
//
//    @Nullable
//    private LocalDateTime timeClosed;
//
//    @OneToMany(mappedBy = "conversation")
//    private List<Message> messageList = new ArrayList<>();
//}
