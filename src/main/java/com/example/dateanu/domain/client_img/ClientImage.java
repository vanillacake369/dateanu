package com.example.dateanu.domain.client_img;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.client.Client;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "client_img")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClientImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    private String img_src_path;
}
