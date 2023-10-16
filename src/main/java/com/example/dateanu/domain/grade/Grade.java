package com.example.dateanu.domain.grade;

public enum Grade {
    Freshman("1학년"), Sophomore("2학년"), Junior("3학년"), Senior("4학년");

    private final String description;

    Grade(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
