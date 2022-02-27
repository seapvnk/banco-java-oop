package com.company.banco;

import com.company.banco.conta.Conta;
import com.company.banco.conta.ContaCorrente;
import com.company.banco.conta.ContaPoupanca;
import com.company.banco.conta.TipoConta;
import com.company.banco.conta.exception.DuplicatedTipoContaException;
import com.company.banco.conta.exception.MaximumAccountsException;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public boolean createConta(TipoConta tipoConta) {
        boolean contaCriada = false;

        try {
            if (contas.toArray().length == 2) {
                throw new MaximumAccountsException();
            }

            if (contas.stream().anyMatch(c -> c.getTipoConta() == tipoConta)) {
                throw new DuplicatedTipoContaException();
            }

            Conta novaConta = null;
            switch (tipoConta) {
                case CONTA_CORRENTE -> novaConta = new ContaCorrente();
                case CONTA_POUPANCA -> novaConta = new ContaPoupanca();
            }

            contas.add(novaConta);
            contaCriada = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return contaCriada;
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaByTipo(TipoConta tipoConta) {
        return contas.stream().filter(c -> c.getTipoConta() == tipoConta).findFirst().get();
    }
}
