package com.example.graphql_spring_boot.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql_spring_boot.entities.Pet;
import com.example.graphql_spring_boot.repositories.PetRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	@Autowired
    private PetRepository PetRepository;

    public Iterable<Pet> pets() {
        return PetRepository.findAll();
    }
}