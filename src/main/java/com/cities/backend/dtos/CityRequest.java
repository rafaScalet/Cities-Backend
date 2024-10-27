package com.cities.backend.dtos;

import jakarta.validation.constraints.*;

public record CityRequest(
  @NotBlank(message = "Name can't be blank")
  @Size(min = 2, message = "Name should have more than two characters")
  String name,

  @NotBlank(message = "State can't be blank")
  @Size(min = 2, message = "State should have more than two characters")
  String state,

  @NotBlank(message = "Country can't be blank")
  @Size(min = 2, message = "Country should have more than two characters")
  String country,

  @NotNull(message = "Age can't be blank")
  Integer age,

  @NotNull(message = "Area can't be blank")
  Double area,

  @NotNull(message = "Population can't be blank")
  Integer population
) { }