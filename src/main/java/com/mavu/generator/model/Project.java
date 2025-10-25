package com.mavu.generator.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Project {
    private String name;
    private String description;
    private List<Entity> entities;
    private List<Endpoint> endpoints;
}
