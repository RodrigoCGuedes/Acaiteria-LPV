package padroescomportamentais.state;

import org.junit.jupiter.api.Test;
import padroescomportamentais.observer.Carrinho;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;

import static org.junit.jupiter.api.Assertions.*;

class EstadoPedidoTest {
    @Test
    void deveRetornarNomeEstadoRealizado() {
        PedidoRealizado estado = new PedidoRealizado();
        assertEquals("Realizado", estado.getNomeEstado());
    }

    @Test
    void deveRetornarNomeEstadoEmPreparo() {
        PedidoEmPreparo estado = new PedidoEmPreparo();
        assertEquals("Em Preparo", estado.getNomeEstado());
    }

    @Test
    void deveRetornarNomeEstadoConcluido() {
        PedidoConcluido estado = new PedidoConcluido();
        assertEquals("Concluído", estado.getNomeEstado());
    }

    @Test
    void deveRetornarNomeEstadoCancelado() {
        PedidoCancelado estado = new PedidoCancelado();
        assertEquals("Cancelado", estado.getNomeEstado());
    }

    @Test
    void deveTransicionarEstadoDeRealizadoParaEmPreparoECancelar() {
        Cliente cliente = new Cliente("Ana");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        String msgPreparo = pedido.prepararPedido();
        assertEquals("Pedido em preparo.", msgPreparo);
        assertTrue(pedido.getEstadoPedido() instanceof PedidoEmPreparo);

        String msgCancelar = pedido.cancelarPedido();
        assertEquals("Pedido cancelado.", msgCancelar);
        assertTrue(pedido.getEstadoPedido() instanceof PedidoCancelado);
    }

    @Test
    void deveNegarRealizarPedidoJaRealizado() {
        Cliente cliente = new Cliente("Ana");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        String msgRealizar = pedido.realizarPedido();
        assertEquals("Pedido já realizado.", msgRealizar);
    }

    @Test
    void deveNegarRealizarPreparoEConclusaoQuandoCancelado() {
        Cliente cliente = new Cliente("Ana");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        pedido.cancelarPedido();
        assertTrue(pedido.getEstadoPedido() instanceof PedidoCancelado);

        assertEquals("Transição não permitida", pedido.realizarPedido());
        assertEquals("Transição não permitida", pedido.prepararPedido());
        assertEquals("Transição não permitida", pedido.concluirPedido());
        assertEquals("Transição não permitida", pedido.cancelarPedido());
    }

    @Test
    void deveNegarTransicoesQuandoConcluido() {
        Cliente cliente = new Cliente("Ana");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        pedido.prepararPedido();
        pedido.concluirPedido();
        assertTrue(pedido.getEstadoPedido() instanceof PedidoConcluido);

        assertEquals("Transição não permitida", pedido.realizarPedido());
        assertEquals("Transição não permitida", pedido.prepararPedido());
        assertEquals("Transição não permitida", pedido.concluirPedido());
        assertEquals("Transição não permitida", pedido.cancelarPedido());
    }

    @Test
    void deveNegarRealizarPedidoQuandoEmPreparo() {
        Cliente cliente = new Cliente("Ana");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        pedido.prepararPedido();
        assertTrue(pedido.getEstadoPedido() instanceof PedidoEmPreparo);

        assertEquals("Transição não permitida", pedido.realizarPedido());
        assertEquals("Transição não permitida", pedido.prepararPedido());
    }
}
