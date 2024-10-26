package com.cities.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cities.backend.dtos.CityResponse;
import com.cities.backend.services.CityService;

@RestController
public class CityController {

  @Autowired
  private CityService service;

  @GetMapping("cities")
  public ResponseEntity<List<CityResponse>> getCities () {
    return ResponseEntity.ok(this.service.getCities());
  }

  @GetMapping("city/{id}")
  public ResponseEntity<CityResponse> getCity (@PathVariable int id) {
    return ResponseEntity.ok(this.service.getCity(id));
  }

}
