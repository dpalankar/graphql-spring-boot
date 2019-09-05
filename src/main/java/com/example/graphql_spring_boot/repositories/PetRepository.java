
package com.example.graphql_spring_boot.repositories;
    
import org.springframework.data.repository.CrudRepository;

import com.example.graphql_spring_boot.entities.Pet;
    
public interface PetRepository extends CrudRepository<Pet, Long> {}