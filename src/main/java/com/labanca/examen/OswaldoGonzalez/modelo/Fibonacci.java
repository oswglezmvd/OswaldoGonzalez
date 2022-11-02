package com.labanca.examen.OswaldoGonzalez.modelo;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

import javax.persistence.*;
@Entity
public class Fibonacci {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long Id;
    public ArrayList<Long> ListaFibonacci;
    public ArrayList<Integer> ListaEstadistica;


    public Fibonacci() {
    }

    public Fibonacci(ArrayList<Long> listaFibonacci, ArrayList<Integer> listaEstadistica) {
        ListaFibonacci = listaFibonacci;
        ListaEstadistica = listaEstadistica;
    }

    public long getId() {
        return Id;
    }


    public ArrayList<Long> getListaFibonacci() {
        return ListaFibonacci;
    }

    public void setListaFibonacci(ArrayList<Long> listaFibonacci) {
        ListaFibonacci = listaFibonacci;
    }

    public ArrayList<Integer> getListaEstadistica() {
        return ListaEstadistica;
    }

    public void setListaEstadistica(ArrayList<Integer> listaEstadistica) {
        ListaEstadistica = listaEstadistica;
    }
}
