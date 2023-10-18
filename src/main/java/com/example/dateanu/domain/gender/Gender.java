package com.example.dateanu.domain.gender;

public enum Gender {
    MALE("남성"), FEMALE("여성");

    private final String genderKor;

    Gender(String genderKor) {
        this.genderKor = genderKor;
    }

    public String getGenderKor() {
        return genderKor;
    }
}