package padroescriacionais.builder;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.state.PedidoRealizado;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;
import padroescriacionais.factorymethod.Dinheiro;

import static org.junit.jupiter.api.Assertions.*;

class PedidoBuilderTest {
    @Test
    void deveConstruirPedidoComSucesso() {
        Cliente cliente = new Cliente("Fabio");
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(300));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Banana banana = new Banana(new BigDecimal("12.00"), semDesconto, tamanho);

        Pedido pedido = new PedidoBuilder()
                .setCliente(cliente)
                .adicionarItem(banana, 2)
                .setFormaPagamento(new Dinheiro())
                .setCupomDesconto("CUPOM10")
                .build();

        assertEquals(new BigDecimal("24.00"), pedido.getValorTotal());
        assertEquals("CUPOM10", pedido.getCupomDesconto());
        assertTrue(pedido.getEstadoPedido() instanceof PedidoRealizado);
        assertTrue(pedido.getFormaPagamento() instanceof Dinheiro);
    }
}
