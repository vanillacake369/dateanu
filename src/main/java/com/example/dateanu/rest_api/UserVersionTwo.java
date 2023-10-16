package com.example.dateanu.rest_api;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
//@Data
@AllArgsConstructor //@RequiredArgsConstructor => not suitable for @Builder, since it only makes constructor for final field.
@NoArgsConstructor
@JsonFilter("UserInfo2")
public class UserVersionTwo extends User{
    private String address;
}
