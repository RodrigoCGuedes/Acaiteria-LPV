package padroescomportamentais.mediator;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.observer.Carrinho;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.state.PedidoEmPreparo;

import static org.junit.jupiter.api.Assertions.*;

class PedidoMediatorTest {
    @Test
    void deveCoordenarPreparoEDispararObserver() {
        Cliente cliente = new Cliente("Isabela");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        PedidoMediator mediator = new PedidoMediator(pedido, cliente);
        String resultado = mediator.solicitarPreparo();

        assertEquals("Mediator coordena preparo: Cliente Isabela notificado do novo estado: Em Preparo", resultado);
        assertTrue(pedido.getEstadoPedido() instanceof PedidoEmPreparo);
    }
}
