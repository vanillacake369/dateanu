package com.example.dateanu.domain.client;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.chat.Chat;
import com.example.dateanu.domain.connection.Connection;
import com.example.dateanu.domain.exclusion.Exclusion;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@Table(name="client")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;

    private String email;

    private String name;

    @Column(name = "phone_num")
    private String phoneNum;

    // client_img 외래키
    private Long img;

    private String studentId;

    // 제외 옵션 선택 여부
    @Column(name = "has_exclude_acquaintance")
    private Boolean hasExcludeAcquaintance;

    /* connection */
    @OneToMany(mappedBy = "maleMatcher")
    List<Connection> maleConnections;

    @OneToMany(mappedBy = "femaleMatcher")
    List<Connection> femaleConnections;

    /* chat */
    @OneToMany(mappedBy = "sender")
    List<Chat> sentChats;

    @OneToMany(mappedBy = "receiver")
    List<Chat> recvChats;

    /* exlusion */
    @OneToMany(mappedBy = "excludeInitClient")
    List<Exclusion> excludeInits;

    @OneToMany(mappedBy = "excludeTargetClient")
    List<Exclusion> excludeTargets;

    @Override
    public String
    toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", img=" + img +
                ", studentId='" + studentId + '\'' +
                ", hasExcludeAcquaintance=" + hasExcludeAcquaintance +
                '}';
    }
}