package com.example.dateanu.rest_api;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@AllArgsConstructor //@RequiredArgsConstructor => not suitable for @Builder, since it only makes constructor for final field.
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
public class User {
    private Integer id;
    @Size(min=2,message = "Name should be at least 2 words")
    private String name;
    @Past
    private Date joinDate;
    private String password;
    @Builder.Default
    private String ssn = null;
}
