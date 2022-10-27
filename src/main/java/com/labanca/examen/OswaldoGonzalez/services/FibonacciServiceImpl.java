package com.labanca.examen.OswaldoGonzalez.services;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import com.labanca.examen.OswaldoGonzalez.repository.FibonacciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FibonacciServiceImpl implements FibonacciService {
    @Autowired
    FibonacciRepository fibonacciRepository;

    @Override
    public ArrayList<Fibonacci> getAllFibonacci() {
        return (ArrayList<Fibonacci>) fibonacciRepository.findAll();
    }

    @Override
    public Fibonacci saveFibonacci(Fibonacci f) {
        return fibonacciRepository.save(f);
    }

    @Override
    public boolean deleteById(long id) {
        try {
            Optional<Fibonacci> f = fibonacciRepository.findById(id);
            fibonacciRepository.delete(f.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean deleteAll(Fibonacci f) {
        try {
            fibonacciRepository.delete(f);
            System.out.println(" Elementos eliminados con exito ");
        } catch (Exception e) {
            System.out.println(" Elementos no fueron eliminados ");
            return false;
        }
        return true;
    }
}
