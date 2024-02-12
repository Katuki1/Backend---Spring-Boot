package com.amigoscode.amigoscode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Getter
@AllArgsConstructor
public class Person {
    private final UUID id;
    private final String name;
}
