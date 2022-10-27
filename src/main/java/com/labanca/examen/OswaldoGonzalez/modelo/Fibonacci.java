package com.labanca.examen.OswaldoGonzalez.modelo;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

import javax.persistence.*;
@Entity
public class Fibonacci {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long Id;
    public ArrayList<Integer> ListaFibonacci;
    public ArrayList<Integer> ListaEstadistica;


    public Fibonacci() {
    }

    public Fibonacci(ArrayList<Integer> listaFibonacci, ArrayList<Integer> listaEstadistica) {
        ListaFibonacci = listaFibonacci;
        ListaEstadistica = listaEstadistica;
    }

    public long getId() {
        return Id;
    }


    public ArrayList<Integer> getListaFibonacci() {
        return ListaFibonacci;
    }

    public void setListaFibonacci(ArrayList<Integer> listaFibonacci) {
        ListaFibonacci = listaFibonacci;
    }

    public ArrayList<Integer> getListaEstadistica() {
        return ListaEstadistica;
    }

    public void setListaEstadistica(ArrayList<Integer> listaEstadistica) {
        ListaEstadistica = listaEstadistica;
    }
}
