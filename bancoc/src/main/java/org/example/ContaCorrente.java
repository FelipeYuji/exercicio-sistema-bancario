package org.example;

import java.math.BigDecimal;

public class ContaCorrente {

    private String numero;
    private String pix1;
    private BigDecimal saldo;

    public ContaCorrente(String numero,String pix1, BigDecimal saldo) {
        this.numero = numero;
        this.pix1 = pix1;
        this.saldo = saldo;
    }


    public String getNumero() {
        return numero;
    }
    public String getPix1() {
        return pix1;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);

    }

    public boolean sacar(BigDecimal valor) {
        if (valor.compareTo(saldo) > 0) {
            return false;
        }
        saldo = saldo.subtract(valor);
        return true;
    }

    public boolean transferir(ContaCorrente destino, BigDecimal valor) {
        if (valor.compareTo(saldo) > 0) {
            return false;
        }
        saldo = saldo.subtract(valor);
        destino.depositar(valor);
        return true;
    }
    public boolean transferirPix(ContaCorrente pixDestino, BigDecimal valor) {
        if (valor.compareTo(saldo) > 0) {
            return false;
        }
        saldo = saldo.subtract(valor);
        pixDestino.depositar(valor);
        return true;
    }


}
