package com.packt.cardatabase.controller;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return this.carRepository.findAll();
    }
}
