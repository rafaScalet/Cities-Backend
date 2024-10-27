package com.cities.backend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cities.backend.dtos.CityRequest;
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

  @PostMapping("city")
  public ResponseEntity<CityResponse> postCity (@RequestBody CityRequest city) {
    CityResponse createdCity = this.service.saveCity(city);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCity.id()).toUri();

    return ResponseEntity.created(location).body(createdCity);
  }

  @DeleteMapping("city/{id}")
  public ResponseEntity<Void> deleteCity (@PathVariable int id) {
    this.service.deleteCity(id);
    return ResponseEntity.noContent().build();
  }

}
