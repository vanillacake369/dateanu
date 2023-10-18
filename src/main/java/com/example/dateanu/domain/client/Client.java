package com.example.dateanu.domain.client;

import com.example.dateanu.domain.BaseEntity;
import com.example.dateanu.domain.chat.Chat;
import com.example.dateanu.domain.client_group.ClientGroup;
import com.example.dateanu.domain.client_img.ClientImage;
import com.example.dateanu.domain.connection.Connection;
import com.example.dateanu.domain.exclusion.Exclusion;
import com.example.dateanu.domain.report.Report;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "client")
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

    private String studentId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "has_exclude_acquaintance")
    private Boolean hasExcludeAcquaintance; // 제외 옵션 선택 여부


    /*** === 외래키 매핑 === ***/
    /* img */
    @OneToMany(mappedBy = "client")
    private List<ClientImage> images;

    /* group */
    @OneToMany(mappedBy = "group")
    private List<ClientGroup> clientGroups;

    /* connection */
    @OneToMany(mappedBy = "maleMatcher")
    private List<Connection> maleConnections;

    @OneToMany(mappedBy = "femaleMatcher")
    private List<Connection> femaleConnections;

    /* chat */
    @OneToMany(mappedBy = "sender")
    private List<Chat> sentChats;

    @OneToMany(mappedBy = "receiver")
    private List<Chat> recvChats;

    /* exlusion */
    @OneToMany(mappedBy = "excludeInitClient")
    private List<Exclusion> excludeInits;

    @OneToMany(mappedBy = "excludeTargetClient")
    private List<Exclusion> excludeTargets;

    /* report */
    @OneToMany(mappedBy = "initiatorClient")
    private List<Report> initReports;

    @OneToMany(mappedBy = "targetClient")
    private List<Report> targetReports;

    @Builder
    private Client(Long id, String email, String name, String phoneNum, String studentId, Gender gender, Boolean hasExcludeAcquaintance) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.studentId = studentId;
        this.gender = gender;
        this.hasExcludeAcquaintance = hasExcludeAcquaintance;
    }
}