package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.state.PedidoEmPreparo;
import padroescomportamentais.state.PedidoConcluido;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    @Test
    void deveNotificarClienteSobreMudancaEstadoPedido() {
        Cliente cliente = new Cliente("Rodrigo");
        Carrinho carrinho = new Carrinho(cliente);
        
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);
        carrinho.adicionarItem(banana, 2);

        Pedido pedido = new Pedido(carrinho);
        pedido.addObserver(cliente);

        assertEquals("Rodrigo", cliente.getNome());
        assertNotNull(cliente.getEnderecos());
        assertEquals(carrinho, cliente.getCarrinho());

        pedido.prepararPedido();
        assertTrue(pedido.getEstadoPedido() instanceof PedidoEmPreparo);
        assertEquals("Em Preparo", cliente.getUltimoEstadoNotificado().getNomeEstado());

        pedido.concluirPedido();
        assertTrue(pedido.getEstadoPedido() instanceof PedidoConcluido);
        assertEquals("Concluído", cliente.getUltimoEstadoNotificado().getNomeEstado());
    }

    @Test
    void devePermitirMultiplosObservadoresENotificarTodos() {
        Cliente c1 = new Cliente("Rodrigo");
        Cliente c2 = new Cliente("Maria");

        Carrinho carrinho = new Carrinho(c1);
        Pedido pedido = new Pedido(carrinho);

        pedido.addObserver(c1);
        pedido.addObserver(c2);

        pedido.prepararPedido();

        assertEquals("Em Preparo", c1.getUltimoEstadoNotificado().getNomeEstado());
        assertEquals("Em Preparo", c2.getUltimoEstadoNotificado().getNomeEstado());
    }

    @Test
    void deveRemoverObservadorENaoNotificaLo() {
        Cliente c1 = new Cliente("Rodrigo");
        Cliente c2 = new Cliente("Maria");

        Carrinho carrinho = new Carrinho(c1);
        Pedido pedido = new Pedido(carrinho);

        pedido.addObserver(c1);
        pedido.addObserver(c2);
        pedido.removeObserver(c2);

        pedido.prepararPedido();

        assertEquals("Em Preparo", c1.getUltimoEstadoNotificado().getNomeEstado());
        assertNull(c2.getUltimoEstadoNotificado());
    }

    @Test
    void deveLancarExcecaoAoRealizarPedidoSemCarrinho() {
        Cliente cliente = new Cliente("Avulso");
        assertThrows(IllegalStateException.class, cliente::realizaPedido);
    }
}
