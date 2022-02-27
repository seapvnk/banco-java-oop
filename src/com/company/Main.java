package com.company;

import com.company.banco.Banco;
import com.company.banco.Cliente;
import com.company.banco.conta.Conta;
import com.company.banco.conta.TipoConta;
import com.company.banco.conta.exception.SaqueException;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente pedro = new Cliente("Pedro");
        Cliente outro = new Cliente("Outro");

        banco.addCliente(pedro);
        banco.addCliente(outro);

        pedro.createConta(TipoConta.CONTA_POUPANCA);
        pedro.createConta(TipoConta.CONTA_CORRENTE);

        outro.createConta(TipoConta.CONTA_CORRENTE);

        Conta contaCorrenteOutro = outro.getContaByTipo(TipoConta.CONTA_CORRENTE);
        Conta contaPoupancaPedro = pedro.getContaByTipo(TipoConta.CONTA_POUPANCA);

        contaCorrenteOutro.deposito(12000);
        contaCorrenteOutro.transferir(5000, contaPoupancaPedro);

        try {
            contaPoupancaPedro.sacar(12000.00);
        } catch (SaqueException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(contaCorrenteOutro.extrato());
        System.out.println(contaPoupancaPedro.extrato());

    }
}
