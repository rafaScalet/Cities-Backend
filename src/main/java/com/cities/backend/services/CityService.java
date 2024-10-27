package com.cities.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cities.backend.dtos.CityRequest;
import com.cities.backend.dtos.CityResponse;
import com.cities.backend.entities.City;
import com.cities.backend.mappers.CityMapper;
import com.cities.backend.repositories.CitiesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {

  private String message = "City not Found";

  @Autowired
  private CitiesRepository repository;

  public List<CityResponse> getCities () {
    return this.repository.findAll().stream().map(item -> CityMapper.toDTO(item)).toList();
  }

  public CityResponse getCity (int id) {
    return CityMapper.toDTO(this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException(message)));
  }

  public CityResponse saveCity (CityRequest request) {
    return CityMapper.toDTO(repository.save(CityMapper.toEntity(request)));
  }

  public void deleteCity (int id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return;
    }

    throw new EntityNotFoundException(message);
  }

  public void updateCity (int id, CityRequest request) {
    City temp = repository.getReferenceById(id);

    temp.setAge(request.age());
    temp.setArea(request.area());
    temp.setCountry(request.country());
    temp.setName(request.name());
    temp.setPopulation(request.population());
    temp.setState(request.state());

    repository.save(temp);
  }

}
