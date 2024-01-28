package org.example.testcontainerssample.repository;


import org.example.testcontainerssample.entity.Greeting;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface GreetingRepository extends Repository<Greeting, Long> {
    Greeting save(Greeting greeting);
}