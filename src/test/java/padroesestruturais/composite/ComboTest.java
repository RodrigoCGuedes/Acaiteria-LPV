package padroesestruturais.composite;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;
import padroesestruturais.decorator.ZeroAcucar;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest {
    @Test
    void deveRetornarPrecoComboComVariosProdutos() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);

        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        ZeroAcucar zero = new ZeroAcucar(new BigDecimal("18.00"), semDesconto, tamanho);

        Combo combo = new Combo("Combo Casal", new BigDecimal("5.00"), semDesconto, tamanho);
        combo.adicionar(banana);
        combo.adicionar(zero);

        assertEquals(new BigDecimal("38.00"), combo.getPrecoBase());
        assertEquals("Combo", combo.getTipo());
        assertEquals(2, combo.getProdutos().size());
    }

    @Test
    void deveRetornarDescricaoCompletaCombo() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);

        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        ZeroAcucar zero = new ZeroAcucar(new BigDecimal("18.00"), semDesconto, tamanho);

        Combo combo = new Combo("Combo Casal", new BigDecimal("5.00"), semDesconto, tamanho);
        combo.adicionar(banana);
        combo.adicionar(zero);

        assertEquals("Combo Casal (Açaí de Banana, Açaí Zero Açúcar)", combo.getDescricao());
    }

    @Test
    void deveRemoverProdutoDoCombo() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);

        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        ZeroAcucar zero = new ZeroAcucar(new BigDecimal("18.00"), semDesconto, tamanho);

        Combo combo = new Combo("Combo Misto", new BigDecimal("5.00"), semDesconto, tamanho);
        combo.adicionar(banana);
        combo.adicionar(zero);
        combo.remover(banana);

        assertEquals(new BigDecimal("23.00"), combo.getPrecoBase());
        assertEquals("Combo Misto (Açaí Zero Açúcar)", combo.getDescricao());
    }

    @Test
    void deveFuncionarComComboVazio() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(300));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);

        Combo combo = new Combo("Combo Vazio", new BigDecimal("4.00"), semDesconto, tamanho);

        assertEquals(new BigDecimal("4.00"), combo.getPrecoBase());
        assertEquals("Combo Vazio", combo.getDescricao());
    }

    @Test
    void deveCalcularPrecoEDescricaoParaComboAninhado() {
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);

        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        ZeroAcucar zero = new ZeroAcucar(new BigDecimal("18.00"), semDesconto, tamanho);

        Combo comboFilho = new Combo("Sub Combo", new BigDecimal("2.00"), semDesconto, tamanho);
        comboFilho.adicionar(banana);

        Combo comboPai = new Combo("Combo Principal", new BigDecimal("5.00"), semDesconto, tamanho);
        comboPai.adicionar(zero);
        comboPai.adicionar(comboFilho);

        assertEquals(new BigDecimal("40.00"), comboPai.getPrecoBase());
        assertEquals("Combo Principal (Açaí Zero Açúcar, Sub Combo (Açaí de Banana))", comboPai.getDescricao());
    }
}
