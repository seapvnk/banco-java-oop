package com.company.banco.conta.exception;

public class MaximumAccountsException extends Exception {

    public MaximumAccountsException() {
        super("Limite de contas excedido");
    }

}
