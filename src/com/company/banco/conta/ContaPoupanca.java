package com.company.banco.conta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        super();
        super.setTipoConta(TipoConta.CONTA_POUPANCA);
    }

    @Override
    public String extrato() {
        StringBuilder extrato = new StringBuilder();

        extrato.append("---------------\n");
        extrato.append("Agencia:       " + super.getAgencia() + "\n");
        extrato.append("Numero:        " + super.getNumero() + "\n");
        extrato.append("Tipo de conta: poupanca\n");
        extrato.append("Saldo:        " + super.getSaldo() + "\n");

        return extrato.toString();
    }

}
