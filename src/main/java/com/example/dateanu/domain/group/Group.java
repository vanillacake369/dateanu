package com.example.dateanu.domain.group;

import com.example.dateanu.domain.client_group.ClientGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "group")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group")
    private List<ClientGroup> clientGroups;

}
