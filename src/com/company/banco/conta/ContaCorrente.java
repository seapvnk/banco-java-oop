package com.company.banco.conta;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
        super();
        super.setTipoConta(TipoConta.CONTA_CORRENTE);
    }

    @Override
    public String extrato() {
        StringBuilder extrato = new StringBuilder();

        extrato.append("---------------\n");
        extrato.append("Agencia:       " + super.getAgencia() + "\n");
        extrato.append("Numero:        " + super.getNumero() + "\n");
        extrato.append("Tipo de conta: conta corrente\n");
        extrato.append("Saldo:        " + super.getSaldo() + "\n");

        return extrato.toString();
    }

}
