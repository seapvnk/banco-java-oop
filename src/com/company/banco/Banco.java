package com.company.banco;

import java.util.ArrayList;

public class Banco {

    private String nome;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Banco() {
        nome = "BANCO D";
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
