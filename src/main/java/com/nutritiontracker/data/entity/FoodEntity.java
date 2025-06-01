package com.nutritiontracker.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private short kcalPer100u;

    @Column(nullable = false, precision = 4, scale = 2) // 00.00 - 99.99
    private BigDecimal protPer100u;

    @Column(nullable = false, precision = 4, scale = 2) // 00.00 - 99.99
    private BigDecimal carbsPer100u;

    @Column(nullable = false, precision = 4, scale = 2) // 00.00 - 99.99
    private BigDecimal fatsPer100u;

    @Column(nullable = false)
    private boolean perWeight; // if not per weight (per 100grams), it's per volume (per 100milliliters)

    @Column(nullable = true, precision = 4, scale = 3) // 0.000 - 9.999
    private BigDecimal volumeToWeightRatio;

}
