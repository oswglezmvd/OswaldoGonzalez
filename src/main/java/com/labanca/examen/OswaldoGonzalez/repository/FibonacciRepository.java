package com.labanca.examen.OswaldoGonzalez.repository;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FibonacciRepository extends CrudRepository<Fibonacci, Long> {
}
