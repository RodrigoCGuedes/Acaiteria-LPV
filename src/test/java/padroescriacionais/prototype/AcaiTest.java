package padroescriacionais.prototype;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.strategy.DescontoCopo;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.ITamanho;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;

import static org.junit.jupiter.api.Assertions.*;

class AcaiTest {
    @Test
    void deveRetornarPrecoNaPromocaoDescontoFixo() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(300));
        DescontoFixo desconto = new DescontoFixo(new BigDecimal("2.50"));
        Acai acai = new Acai("Açaí Tradicional", new BigDecimal("12.00"), desconto, tamanho, "Tradicional");

        assertEquals(new BigDecimal("9.50"), acai.calculaPrecoNaPromocao());
    }

    @Test
    void deveRetornarPrecoNaPromocaoDescontoCopo() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoCopo desconto = new DescontoCopo(new BigDecimal("0.10")); // 10% desconto
        Acai acai = new Acai("Açaí Especial", new BigDecimal("20.00"), desconto, tamanho, "Especial");

        assertEquals(new BigDecimal("18.00"), acai.calculaPrecoNaPromocao());
    }

    @Test
    void deveClonarAcaiCorretamente() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo desconto = new DescontoFixo(BigDecimal.ZERO);
        Acai original = new Acai("Açaí Morango", new BigDecimal("15.00"), desconto, tamanho, "Morango");

        Acai clone = original.clone();
        assertNotSame(original, clone);
        assertEquals(original.getDescricao(), clone.getDescricao());
        assertEquals(original.getPrecoBase(), clone.getPrecoBase());
        assertEquals(original.getTipoAcaiBase(), clone.getTipoAcaiBase());
        assertEquals(original.getQtdMl(), clone.getQtdMl());
        assertEquals(original.getPromocao(), clone.getPromocao());
        assertEquals(original.getTamanho(), clone.getTamanho());
    }

    @Test
    void deveRetornarPrecoOriginalQuandoSemPromocao() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        Acai acai = new Acai("Açaí Puro", new BigDecimal("15.00"), null, tamanho, "Puro");

        assertEquals(new BigDecimal("15.00"), acai.calculaPrecoNaPromocao());
    }

    @Test
    void deveRetornarZeroMlQuandoSemTamanho() {
        Acai acai = new Acai("Açaí Puro", new BigDecimal("15.00"), null, null, "Puro");

        assertEquals(0, acai.getQtdMl());
    }

    @Test
    void deveRetornarZeroMlQuandoFormatoTamanhoInvalido() {
        ITamanho tamanhoInvalido = new ITamanho() {
            @Override
            public String getTamanho() {
                return "Grande";
        };
        Acai acai = new Acai("Açaí Puro", new BigDecimal("15.00"), null, tamanhoInvalido, "Puro");

        assertEquals(0, acai.getQtdMl());
    }
}
