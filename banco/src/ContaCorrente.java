import java.math.BigDecimal;

class ContaCorrente {

    private String numero;
    private BigDecimal saldo;

    public ContaCorrente(String numero, BigDecimal saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }


    public String getNumero() {
        return numero;
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

}