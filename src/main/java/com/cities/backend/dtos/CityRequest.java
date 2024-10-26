package com.cities.backend.dtos;

public record CityRequest(String name, String state, String country, Integer age, Double area, Integer population) { }