package com.example.dateanu.rest_api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class GrettingUser extends RepresentationModel<GrettingUser> {
    private final User user;

    @JsonCreator
    public GrettingUser(@JsonProperty("content") User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
