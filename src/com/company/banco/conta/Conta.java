package com.company.banco.conta;

import com.company.banco.conta.exception.SaqueException;

public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 0;
    protected static final int AGENCIA_PADRAO = 1;

    protected TipoConta tipoConta;
    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = ++SEQUENCIAL;
    }

    @Override
    public void sacar(double valor) throws SaqueException {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            throw new SaqueException("Saldo insuficiente");
        }
    }

    @Override
    public void deposito(double valor) {
        saldo += valor;
    }

    @Override
    public boolean transferir(double valor, Conta conta) {
        boolean saqueSuccess = true;
        try {
            sacar(valor);
            conta.deposito(valor);
        } catch (SaqueException e) {
            saqueSuccess = false;
        }

        return saqueSuccess;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    protected void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
