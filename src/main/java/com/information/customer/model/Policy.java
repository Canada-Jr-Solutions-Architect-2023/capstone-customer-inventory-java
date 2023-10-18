package com.information.customer.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Policy {

    private Long id;

    private String title;

    @Convert(converter = LevelConverter.class)
    @Enumerated(EnumType.STRING)
    private Level level;

    private String description;

    private double coverage;

    private double premium;

    public Policy(){}
    public Policy(String title, Level level, String description, double coverage, double premium) {
        this.title = title;
        this.level = level;
        this.description = description;
        this.coverage = coverage;
        this.premium = premium;
    }

    public Policy(Long id, String title, Level level, String description, double coverage, double premium) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.description = description;
        this.coverage = coverage;
        this.premium = premium;
    }
}
