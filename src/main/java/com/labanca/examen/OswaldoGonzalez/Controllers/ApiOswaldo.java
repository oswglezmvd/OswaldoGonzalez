package com.labanca.examen.OswaldoGonzalez.Controllers;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import com.labanca.examen.OswaldoGonzalez.services.FibonacciService;
import org.junit.jupiter.api.Test;
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
    public Long calculoFibonacci(@PathVariable int n) {
        return (fibonacciService.calculoFibonacci(n));
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id) {
        if (fibonacciService.deleteById(id))
            return true;

        return false;
    }

    @GetMapping("/est/{desde}")
    public HashMap<Integer, Integer> getEstFib(@PathVariable("desde") int desde) {
        ArrayList<Fibonacci> estadistica = getAllFibonacci();
        ArrayList<Integer> estF = estadistica.get(0).ListaEstadistica;

        HashMap<Integer, Integer> mapEst = new LinkedHashMap();

        if (estadistica.size() == 0) {
            System.out.println("No consiguio estadisticas");
            return mapEst;
        }

        for (int i = 0; i < estF.size(); i++) {
            if(estF.get(i) > desde){
                mapEst.put(i, estF.get(i));
            }
        }
        return mapEst.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
