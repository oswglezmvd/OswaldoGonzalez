/*
package com.labanca.examen.OswaldoGonzalez.services;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import com.labanca.examen.OswaldoGonzalez.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping("lab")

public class Respaldo {
    @Autowired
    FibonacciService fibonacciService;

    @GetMapping("/saludar")
    public String saludar() {
        return "Hola Mundo! desde La Banca";
    }

    @GetMapping("/all")
    public ArrayList<Fibonacci> getAllFibonacci() {
        return fibonacciService.getAllFibonacci();
    }

    @PostMapping("/fibn/{n}")
    public Integer calculoFibonacci(@PathVariable int n) {
        int k = 3;
        Fibonacci f1 = new Fibonacci();
        ArrayList<Integer> fib1 = new ArrayList<>(500);
        ArrayList<Integer> fib2 = new ArrayList<>(500);
        ArrayList<Fibonacci> fibn = getAllFibonacci();
//        System.out.println(" listas encontradas " + fibn.size());
        if(fibn.size()>0){
            System.out.println("la lista  " +  fibn.size());
            fib1 = fibn.get(0).ListaFibonacci;
            fib2 = fibn.get(0).ListaEstadistica;
            k = (fib1.size());
//            System.out.println( " existe " + fib1);
            if (n <= fib1.size()) {
                System.out.println("Se metio por el cache");
                fib2.set(n,(fib2.get(n) + 1));
                fibn.get(0).setListaEstadistica(fib2);
                fibonacciService.saveFibonacci(fibn.get(0));
                return fib1.get(n);
            }
        } else {
//            System.out.println("no existe = " + n);
            fib1.add(0);
            fib1.add(1);
            fib1.add(1);
            fib2.add(0);
            fib2.add(0);
            fib2.add(0);
        }

        System.out.println("Se metio por fuera del cache " + k + "  cont i " + fib1.get(k-1));
        System.out.println("fib1.get((k - 1) = " + fib1.get((k - 1)));
        System.out.println("fib1.get((k - 2) = " + fib1.get((k - 2)));



        for (int i = k  ; i <= n; i++) {
//            System.out.println(" pos  " + i);
//            System.out.println(  i - 2  + (fib1.get((i - 2) )));
//            System.out.println(  i - 1  + (fib1.get((i - 1) )));
            fib1.add((fib1.get((i - 2)) + (fib1.get(i - 1))));
            fib2.add(0);
            System.out.println(" alm = " + fib1.get(i));
        }
        System.out.println("Antes de fibn.size() = " + fib1.size());
        //   Fibonacci f = new Fibonacci();
        //      Fibonacci fibNuevo = new Fibonacci();
        //      fibn.get(0).setListaFibonacci(fib1);
        //       fibonacciService.saveFibonacci(f1);

        System.out.println("tamanos fib1  fib2 = " + fib1.size() + fib2.size());
        if (fib2.size() == 0){
            System.out.println("fib1.size() = " + fib1.size());
            for (int i = 0  ; i <= fib1.size(); i++) {
                fib2.add(0);
                System.out.println("i = " + i);
            }
        }

        fib2.set(n,(fib2.get(n) + 1));
        f1.setListaFibonacci(fib1);
        f1.setListaEstadistica(fib2);
        fibonacciService.saveFibonacci(f1);

        //       fibn.get(0).setListaEstadistica(fib2);
       fibn.get(0).setListaEstadistica(fib2);
        fibn.get(0).setListaFibonacci(fib1);
        fibonacciService.saveFibonacci(fibn.get(0));

        return fib1.get(n);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id) {
        if (fibonacciService.deleteById(id))
            return "Se ha eliminado correctamente";
        else
            return "No se ha eliminado por Id";
    }
    @DeleteMapping("/del/all")
    public String deleteAll(Fibonacci f) {
        if (fibonacciService.deleteAll(f))
            return "Se ha eliminado todo correctamente";
        else
            return "No se ha eliminado nada";
    }
}
*/
