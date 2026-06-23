package padroescomportamentais.iterator;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;
import padroesestruturais.decorator.Produto;

import static org.junit.jupiter.api.Assertions.*;

class IteratorAcaiNaPromocaoTest {
    @Test
    void deveFiltrarApenasProdutosEmPromocao() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(300));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        DescontoFixo comDesconto = new DescontoFixo(new BigDecimal("2.00"));

        Banana p1 = new Banana(new BigDecimal("12.00"), semDesconto, tamanho);
        Banana p2 = new Banana(new BigDecimal("15.00"), comDesconto, tamanho);
        Banana p3 = new Banana(new BigDecimal("10.00"), semDesconto, tamanho);
        Banana p4 = new Banana(new BigDecimal("18.00"), comDesconto, tamanho);

        List<Produto> lista = Arrays.asList(p1, p2, p3, p4);
        Iterator iterator = new IteratorAcaiNaPromocao(lista);

        assertTrue(iterator.temProximo());
        Produto proximo1 = iterator.proximo();
        assertEquals(p2, proximo1);

        assertTrue(iterator.temProximo());
        Produto proximo2 = iterator.proximo();
        assertEquals(p4, proximo2);

        assertFalse(iterator.temProximo());
    }
}
