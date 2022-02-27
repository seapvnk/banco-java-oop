package com.company.banco.conta.exception;

public class DuplicatedTipoContaException extends Exception {

    public DuplicatedTipoContaException() {
        super("Limite de contas do mesmo tipo excedido");
    }

}
