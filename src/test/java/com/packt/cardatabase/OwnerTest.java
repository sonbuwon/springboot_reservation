package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.repository.CarRepository;
import com.packt.cardatabase.repository.OwnerRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Log4j2
public class OwnerTest {

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    CarRepository carRepository;

    @Test
    public void testOwner() {
        Owner owner1 = new Owner();
        owner1.setFirstname("John");
        owner1.setLastname("Robinson");

        Owner owner2 = new Owner();
        owner2.setFirstname("Mary");
        owner2.setLastname("Johnson");

        this.ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        Car car2 = new Car(2L, "BMW", "i5", "Black", "G60e", 2023, 70000, owner1);
        Car car3 = new Car(3L, "Benz", "E250", "Silver", "A43eT", 2019, 35000, owner2);
        this.carRepository.save(car2);
        this.carRepository.save(car3);
    }
}
