package com.javarush.babkin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String login;

    private String password;

    private Role role;

    public String getImage() {return "image-" + id; }

}
