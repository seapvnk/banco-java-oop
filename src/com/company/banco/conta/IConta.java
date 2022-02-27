package com.company.banco.conta;

import com.company.banco.conta.exception.SaqueException;

public interface IConta {
    void sacar(double valor) throws SaqueException;

    void deposito(double valor);

    boolean transferir(double valor, Conta conta);

    String extrato();
}
