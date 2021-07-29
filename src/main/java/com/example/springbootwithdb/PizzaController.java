package com.example.springbootwithdb;

import com.example.springbootwithdb.dto.PizzaDto;
import com.example.springbootwithdb.entities.Pizza;
import com.example.springbootwithdb.mappers.PizzaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    private final PizzaRepository pizzaRepository;
    private final ModelMapper mapper = new ModelMapper();

    public PizzaController(PizzaRepository pizzaRepository, ModelMapper mapper) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/pizzas")
    List<Pizza> findAllPizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/pizzas/{id}")
    Optional<Pizza> findById(@PathVariable("id") Integer id) {
        return pizzaRepository.findById(id);
    }

    @GetMapping("/findonepizza")
    Pizza findOnePizza(String name) {
        return pizzaRepository.findByName(name);
    }

    @PostMapping("/pizzas")
    PizzaDto savePizza(@RequestBody PizzaDto pizza) {
        return PizzaMapper.entityToDto(pizzaRepository.save(PizzaMapper.dtoToEntity(pizza)));
    }
}
