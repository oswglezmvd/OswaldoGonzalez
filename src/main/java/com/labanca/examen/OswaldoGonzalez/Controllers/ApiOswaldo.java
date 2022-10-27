package com.labanca.examen.OswaldoGonzalez.Controllers;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import com.labanca.examen.OswaldoGonzalez.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("lab")

public class ApiOswaldo {
    @Autowired
    FibonacciService fibonacciService;

    @GetMapping("/all")
    public ArrayList<Fibonacci> getAllFibonacci() {
        return fibonacciService.getAllFibonacci();
    }

    @PostMapping("/fibn/{n}")
    public Integer calculoFibonacci(@PathVariable int n) {
        int k = 3;
        //       Fibonacci f1 = new Fibonacci();
        ArrayList<Integer> fib1 = new ArrayList<>(500);
        ArrayList<Integer> estF = new ArrayList<>(500);
        ArrayList<Fibonacci> fibn = getAllFibonacci();
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

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id) {
        if (fibonacciService.deleteById(id))
            return true;

        return false;
    }

    @GetMapping("/del/all")
    public String deleteAll(Fibonacci f) {
        if (fibonacciService.deleteAll(f))
            return "Se ha eliminado todo correctamente";
        else
            return "No se ha eliminado nada";
    }

    @GetMapping("/est/{desde}")
    public HashMap<Integer, Integer> getEstFib(@PathVariable("desde") int desde) {
        ArrayList<Fibonacci> estadistica = getAllFibonacci();
        ArrayList<Integer> estF = estadistica.get(0).ListaEstadistica;
//        System.out.println("estF.size() = " + estF.size());

        HashMap<Integer, Integer> sale = new LinkedHashMap();

        if (estadistica.size() == 0) {
            System.out.println("No consiguio estadisticas");
            return sale;
        }

        for (int i = 0; i < estF.size(); i++) {
            if(estF.get(i) > desde){
                sale.put(i, estF.get(i));
            }
        }
        return sale.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
