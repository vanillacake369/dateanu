package com.example.dateanu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
// @Setter
public class HelloLombok {
    private String hello;
    private int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
