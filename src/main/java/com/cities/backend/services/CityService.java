package com.cities.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cities.backend.dtos.CityResponse;
import com.cities.backend.mappers.CityMapper;
import com.cities.backend.repositories.CitiesRepository;

@Service
public class CityService {

  @Autowired
  private CitiesRepository repository;

  public List<CityResponse> getCities () {
    return this.repository.findAll().stream().map(item -> CityMapper.toDTO(item)).toList();
  }

}
