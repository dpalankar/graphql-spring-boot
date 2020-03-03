package com.example.graphql_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.graphql_spring_boot.model.User;

@SpringBootApplication
@EntityScan(basePackageClasses=User.class)
public class GraphQLSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLSpringBootApplication.class, args);
    }
}