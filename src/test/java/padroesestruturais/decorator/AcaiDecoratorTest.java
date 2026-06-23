package padroesestruturais.decorator;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;

import static org.junit.jupiter.api.Assertions.*;

class AcaiDecoratorTest {
    @Test
    void deveRetornarPrecoAcaiComAdicionais() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Produto acai = new Banana(new BigDecimal("10.00"), semDesconto, tamanho);

        acai = new CaldaMorango(acai);
        acai = new Granola(acai);

        assertEquals(new BigDecimal("14.30"), acai.getPrecoBase());
    }

    @Test
    void deveRetornarDescricaoAcaiComAdicionais() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Produto acai = new ZeroAcucar(new BigDecimal("12.00"), semDesconto, tamanho);

        acai = new Granola(acai);
        acai = new CaldaMorango(acai);

        assertEquals("Açaí Zero Açúcar, Granola, Calda de Morango", acai.getDescricao());
    }
}
