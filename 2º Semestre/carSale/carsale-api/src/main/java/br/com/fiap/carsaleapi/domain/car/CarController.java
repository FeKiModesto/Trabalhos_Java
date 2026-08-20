package br.com.fiap.carsaleapi.domain.car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getAllCars() {
        return carService.getAllCars().stream().map(CarResponse::fromModel).toList();
    }

    @GetMapping("{id}")
    public CarResponse getCarById(@PathVariable Long id) {
        return CarResponse.fromModel( carService.getCarById(id) );
    }

}
