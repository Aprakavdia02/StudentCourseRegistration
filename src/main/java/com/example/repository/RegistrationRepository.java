package com.example.repository;

import com.example.model.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<Registration,Integer> {
}
