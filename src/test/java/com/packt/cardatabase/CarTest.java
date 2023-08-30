package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.repository.CarRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CarTest {
    /*
    *   private Long id;
        private String brand, model, color, registerNumber;
        private int year, price;
    */
    @Autowired
    CarRepository carRepository;

    @Test
    public void testCar() {
//        Car car1 = new Car(1L, "Audi", "A7", "White", "55TFSI", 2023, 50000);
//        Car car2 = new Car(2L, "BMW", "i5", "Black", "G60e", 2023, 70000);
//        Car car3 = new Car(3L, "Benz", "E250", "Silver", "A43eT", 2019, 35000);
//        this.carRepository.save(car2);
//        this.carRepository.save(car3);
    }

    @Test
    public void testCarIn() {
        for(Car car : this.carRepository.findAll()) {
            log.info(car.getBrand() + ", " + car.getModel() + ", " + car.getColor());
        }
    }

}
