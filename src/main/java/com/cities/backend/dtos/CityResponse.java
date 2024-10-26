package com.cities.backend.dtos;

public record CityResponse(Integer id, String name, String state, String country, Integer age, Double area, Integer population) { }