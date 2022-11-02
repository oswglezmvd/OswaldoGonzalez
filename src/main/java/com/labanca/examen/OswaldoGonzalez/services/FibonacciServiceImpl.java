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

    public Long calculoFibonacci(int n) {
        int k = 3;
        ArrayList<Long> fib1 = new ArrayList<>(500);
        ArrayList<Integer> estF = new ArrayList<>(500);

        ArrayList<Fibonacci> fibn = getAllFibonacci();
        if (fibn.size() > 0) {
            fib1 = fibn.get(0).ListaFibonacci;
            estF = fibn.get(0).ListaEstadistica;
            k = (fib1.size());
            if (n <= fib1.size()) {
                estF.set(n, (estF.get(n) + 1));
                fibn.get(0).setListaEstadistica(estF);
                saveFibonacci(fibn.get(0));
                return fib1.get(n);
            }
        } else {
            fib1.add(0L);
            fib1.add(1L);
            fib1.add(1L);
            estF.add(0);
            estF.add(0);
            estF.add(0);
        }

        for (int i = k; i <= n; i++) {
            fib1.add((fib1.get((i - 2)) + (fib1.get(i - 1))));
            estF.add(0);
        }
        estF.set(n,(estF.get(n) + 1));
        if (fibn.size() == 0) {
            Fibonacci f1 = new Fibonacci(fib1, estF);
            saveFibonacci(f1);
        } else {
            fibn.get(0).setListaFibonacci(fib1);
            fibn.get(0).setListaEstadistica(estF);
            saveFibonacci(fibn.get(0));
        }
        return fib1.get(n);
    }
}
