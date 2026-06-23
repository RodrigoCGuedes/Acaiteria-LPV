package padroescomportamentais.memento;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.observer.Carrinho;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;

import static org.junit.jupiter.api.Assertions.*;

class MementoTest {
    @Test
    void deveSalvarERestaurarEstadoPedido() {
        Cliente cliente = new Cliente("Carlos");
        Carrinho carrinho = new Carrinho(cliente);
        
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(300));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Banana banana = new Banana(new BigDecimal("10.00"), semDesconto, tamanho);
        carrinho.adicionarItem(banana, 2);

        Pedido pedido = new Pedido(carrinho);
        pedido.setCupomDesconto("CUPOM20");

        HistoricoPedido historico = new HistoricoPedido();
        assertEquals(0, historico.getQtdEstadosSalvos());

        historico.salvarEstado(pedido);
        assertEquals(1, historico.getQtdEstadosSalvos());

        pedido.setValorTotal(new BigDecimal("50.00"));
        pedido.setCupomDesconto("CUPOM50");

        assertEquals(new BigDecimal("50.00"), pedido.getValorTotal());
        assertEquals("CUPOM50", pedido.getCupomDesconto());

        historico.restaurarEstado(pedido);
        assertEquals(0, historico.getQtdEstadosSalvos());
        assertEquals(new BigDecimal("20.00"), pedido.getValorTotal());
        assertEquals("CUPOM20", pedido.getCupomDesconto());
    }

    @Test
    void deveIgnorarRestauracaoSeHistoricoVazio() {
        Cliente cliente = new Cliente("Carlos");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);
        pedido.setCupomDesconto("CUPOM100");
        BigDecimal valorOriginal = pedido.getValorTotal();

        HistoricoPedido historico = new HistoricoPedido();
        historico.restaurarEstado(pedido);

        assertEquals(valorOriginal, pedido.getValorTotal());
        assertEquals("CUPOM100", pedido.getCupomDesconto());
    }

    @Test
    void deveIgnorarRestauracaoDeMementoNulo() {
        Cliente cliente = new Cliente("Carlos");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);
        pedido.setCupomDesconto("CUPOM100");
        BigDecimal valorOriginal = pedido.getValorTotal();

        pedido.restaurar(null);

        assertEquals(valorOriginal, pedido.getValorTotal());
        assertEquals("CUPOM100", pedido.getCupomDesconto());
    }

    @Test
    void deveRetornarValoresDoMemento() {
        PedidoMemento memento = new PedidoMemento(100, "CUPOMVAL");
        assertEquals(100, memento.getValorTotal());
        assertEquals("CUPOMVAL", memento.getCupomDesconto());
    }
}
