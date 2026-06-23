package padroescomportamentais.templatemethod;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import padroescomportamentais.observer.Carrinho;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;

import static org.junit.jupiter.api.Assertions.*;

class ExportadorRelatorioTemplateTest {
    @Test
    void deveGerarRelatorioEstoque() {
        Cliente cliente = new Cliente("Edgar");
        Carrinho carrinho = new Carrinho(cliente);
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        carrinho.adicionarItem(banana, 3);

        Pedido pedido = new Pedido(carrinho);
        List<Pedido> pedidos = Arrays.asList(pedido);

        ExportadorRelatorioTemplate exportador = new RelatorioEstoque();
        String relatorio = exportador.exportar(pedidos);

        String esperado = "Cabeçalho\nTotal de itens açaí produzidos: 3\nFim do relatório de estoque.";
        assertEquals(esperado, relatorio);
    }

    @Test
    void deveGerarRelatorioFaturamento() {
        Cliente cliente = new Cliente("Edgar");
        Carrinho carrinho = new Carrinho(cliente);
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        carrinho.adicionarItem(banana, 2);

        Pedido pedido = new Pedido(carrinho);
        List<Pedido> pedidos = Arrays.asList(pedido);

        ExportadorRelatorioTemplate exportador = new RelatorioFaturamento();
        String relatorio = exportador.exportar(pedidos);

        String esperado = "Cabeçalho\nFaturamento Total: R$ 30.00\nFim do relatório de faturamento.";
        assertEquals(esperado, relatorio);
    }
}
