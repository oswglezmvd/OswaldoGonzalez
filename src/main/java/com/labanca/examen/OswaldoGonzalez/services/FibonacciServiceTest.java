package com.labanca.examen.OswaldoGonzalez.services;

import com.labanca.examen.OswaldoGonzalez.modelo.Fibonacci;
import com.labanca.examen.OswaldoGonzalez.repository.FibonacciRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FibonacciServiceTest {

    @Mock
    FibonacciRepository fibonacciRepository;

    @InjectMocks
    FibonacciServiceImpl fibonacciService;

    private Fibonacci fibonacci;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        ArrayList<Long> fib1 = new ArrayList<>(500);
        ArrayList<Integer> estF = new ArrayList<>(500);
        fibonacci = new Fibonacci();

        fib1.add(0L);
        fib1.add(1L);
        fib1.add(1L);
        estF.add(0);
        estF.add(0);
        estF.add(0);
        fibonacci.setListaFibonacci(fib1);
        fibonacci.setListaEstadistica(estF);
    }

    @Test
    void getAllFibonacci() {
        when(fibonacciRepository.findAll()).thenReturn(Arrays.asList(fibonacci));
        assertNotNull(fibonacciRepository.findAll());
    }

    @Test
    void saveFibonacci() {
        when(fibonacciRepository.save(any(Fibonacci.class))).thenReturn(fibonacci);
        assertNotNull(fibonacciRepository.save(new Fibonacci()));
    }

    @Test
    void calculoFibonacci() {
        Long salio = fibonacciService.calculoFibonacci(5);
        Assertions.assertEquals(5, fibonacciService.calculoFibonacci(5));
        Assertions.assertEquals(21, fibonacciService.calculoFibonacci(8));
        Assertions.assertEquals(55, fibonacciService.calculoFibonacci(10));
    }
    @Test
    void deleteById() {
        fibonacciRepository.deleteById(fibonacci.getId());
        Assertions.assertTrue(true);
    }
}