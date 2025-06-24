package com.example.first_spring.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegularUser {
    private String username;
    private String email;
}



