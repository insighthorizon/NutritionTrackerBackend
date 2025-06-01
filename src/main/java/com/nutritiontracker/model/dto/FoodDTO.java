package com.nutritiontracker.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class FoodDTO {

    private long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

    @Min(value = 0)
    @Max(value = 900) // maximum kcal if it is 100grams of fat per 100grams of food, it's less than 100 grams in 100 ml (fat density)
    private short kcalPer100u;

    private BigDecimal protPer100u;

    private BigDecimal carbsPer100u;

    private BigDecimal fatsPer100u;

    private boolean perWeight; // if not per weight (per 100grams), it's per volume (per 100milliliters)

    private BigDecimal volumeToWeightRatio;

}
