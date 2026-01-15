package com.Juan.StephenKingBook.principal;

import com.Juan.StephenKingBook.service.ConsumoApi;

public class Principal {

    private ConsumoApi consumoApi = new ConsumoApi();

    public void mostrarMenu(){
        System.out.println("Bienvenido al sistema de libros de Stephen King");
    }
}
