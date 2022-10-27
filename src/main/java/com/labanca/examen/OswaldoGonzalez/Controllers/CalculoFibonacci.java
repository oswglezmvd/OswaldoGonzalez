package com.labanca.examen.OswaldoGonzalez.Controllers;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import com.labanca.examen.OswaldoGonzalez.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class CalculoFibonacci {

    @Autowired
    static
    FibonacciService fibonacciService;


    public static Integer calculoFibonacci(int n) {
        int k = 3;
        //       Fibonacci f1 = new Fibonacci();
        ArrayList<Integer> fib1 = new ArrayList<>(500);
        ArrayList<Integer> estF = new ArrayList<>(500);
        ArrayList<Fibonacci> fibn = fibonacciService.getAllFibonacci();
        if (fibn.size() > 0) {
            fib1 = fibn.get(0).ListaFibonacci;
            estF = fibn.get(0).ListaEstadistica;
            k = (fib1.size());
            if (n <= fib1.size()) {
                estF.set(n, (estF.get(n) + 1));
                fibn.get(0).setListaEstadistica(estF);
                fibonacciService.saveFibonacci(fibn.get(0));
                return fib1.get(n);
            }
        } else {
            fib1.add(0);
            fib1.add(1);
            fib1.add(1);
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
            fibonacciService.saveFibonacci(f1);
        } else {
            fibn.get(0).setListaFibonacci(fib1);
            fibn.get(0).setListaEstadistica(estF);
            fibonacciService.saveFibonacci(fibn.get(0));
        }
        return fib1.get(n);
    }
}
