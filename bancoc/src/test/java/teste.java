import org.example.ContaCorrente;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

//Ficou sem a funcionalidade do boleto

public class teste {
    @Test
    public void testeCriacaoConta(){
        ContaCorrente test = new ContaCorrente("12","pix@gmail.com", BigDecimal.valueOf(12));
        Assertions.assertEquals("12", test.getNumero() );
        Assertions.assertEquals("pix@gmail.com", test.getPix1() );
        Assertions.assertEquals(BigDecimal.valueOf(12), test.getSaldo() );
    }
    @Test
    public void testeSaque(){
        ContaCorrente testeS = new ContaCorrente("1234","alo@gmail.com",BigDecimal.valueOf(1000));
        testeS.sacar(BigDecimal.valueOf(200));

        Assert.assertEquals(BigDecimal.valueOf(800), testeS.getSaldo());
    }
    @Test
    public void testeDeposito(){
        ContaCorrente testeD = new ContaCorrente("1234","alo@gmail.com",BigDecimal.valueOf(1000));
        testeD.depositar(BigDecimal.valueOf(200));

        Assert.assertEquals(BigDecimal.valueOf(1200), testeD.getSaldo());
    }
    @Test
    public void testeTransferencia(){
        ContaCorrente testeT1 = new ContaCorrente("1234","alo@gmail.com",BigDecimal.valueOf(1000));
        ContaCorrente testeT2 = new ContaCorrente("4321","alo2@gmail.com",BigDecimal.valueOf(1000));
        testeT1.transferir(testeT2 ,BigDecimal.valueOf(500));

        Assert.assertEquals(BigDecimal.valueOf(500), testeT1.getSaldo());
        Assert.assertEquals(BigDecimal.valueOf(1500), testeT2.getSaldo());
    }
    @Test
    public void testeTransferenciaPix(){
        ContaCorrente testeT1 = new ContaCorrente("1234","alo@gmail.com",BigDecimal.valueOf(1000));
        ContaCorrente testeT2 = new ContaCorrente("4321","alo2@gmail.com",BigDecimal.valueOf(1000));
        testeT2.transferirPix(testeT1 ,BigDecimal.valueOf(500));

        Assert.assertEquals(BigDecimal.valueOf(1500), testeT1.getSaldo());
        Assert.assertEquals(BigDecimal.valueOf(500), testeT2.getSaldo());
    }
}
