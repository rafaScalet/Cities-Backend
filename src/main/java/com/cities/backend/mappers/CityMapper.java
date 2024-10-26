package com.cities.backend.mappers;

import com.cities.backend.dtos.CityRequest;
import com.cities.backend.dtos.CityResponse;
import com.cities.backend.entities.City;

public class CityMapper {

  public static City toEntity (CityRequest request) {
    return new City(
      request.name(),
      request.state(),
      request.country(),
      request.age(),
      request.area(),
      request.population()
    );
  }

  public static CityResponse toDTO (City city) {
    return new CityResponse(
      city.getId(),
      city.getName(),
      city.getState(),
      city.getCountry(),
      city.getAge(),
      city.getArea(),
      city.getPopulation()
    );
  }

}
