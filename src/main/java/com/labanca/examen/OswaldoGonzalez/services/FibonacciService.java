package com.labanca.examen.OswaldoGonzalez.services;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface FibonacciService {
    ArrayList<Fibonacci> getAllFibonacci();
    Fibonacci saveFibonacci(Fibonacci f);
    boolean deleteById(long id);
    Long calculoFibonacci(int n);


}