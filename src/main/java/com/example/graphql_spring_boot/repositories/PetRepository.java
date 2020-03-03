
package com.example.graphql_spring_boot.repositories;
    
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql_spring_boot.entities.Pet;
    
public interface PetRepository extends JpaRepository<Pet, Long> {}