package padroescomportamentais.command;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.observer.Carrinho;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.state.PedidoEmPreparo;
import padroescriacionais.factorymethod.Dinheiro;

import static org.junit.jupiter.api.Assertions.*;

class CommandPedidoTest {
    @Test
    void deveExecutarFluxoPedidoComSucesso() {
        Cliente cliente = new Cliente("Daniel");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);
        pedido.setFormaPagamento(new Dinheiro());

        FluxoPedido fluxo = new FluxoPedido();
        fluxo.adicionarComando(new AguardaConfirmacaoCommand(pedido));
        fluxo.adicionarComando(new AceitaPedidoCommand(pedido));

        assertTrue(fluxo.executarFluxo());
        assertTrue(pedido.getEstadoPedido() instanceof PedidoEmPreparo);
    }

    @Test
    void deveFalharFluxoSemPagamento() {
        Cliente cliente = new Cliente("Daniel");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        FluxoPedido fluxo = new FluxoPedido();
        fluxo.adicionarComando(new AguardaConfirmacaoCommand(pedido));
        fluxo.adicionarComando(new AceitaPedidoCommand(pedido));

        assertFalse(fluxo.executarFluxo());
    }
}
