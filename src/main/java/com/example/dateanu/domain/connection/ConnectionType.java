package com.example.dateanu.domain.connection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConnectionType {
    RANDOM("랜덤 매칭"), SELECTION("대화방 선택");

    private final String text;
}
