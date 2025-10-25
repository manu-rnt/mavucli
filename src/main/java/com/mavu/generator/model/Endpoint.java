package com.mavu.generator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Endpoint {
    private String method;
    private String path;
    private String action;
}
