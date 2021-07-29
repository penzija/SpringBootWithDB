package com.example.springbootwithdb.mappers;

import com.example.springbootwithdb.dto.PizzaDto;
import com.example.springbootwithdb.entities.Pizza;

public class PizzaMapper {

    public static Pizza dtoToEntity(PizzaDto pizzaDto) {
        return new Pizza(pizzaDto.id, pizzaDto.name);
    }

    public static PizzaDto entityToDto(Pizza pizza) {
        return new PizzaDto(pizza.getId(), pizza.getName());
    }
}
