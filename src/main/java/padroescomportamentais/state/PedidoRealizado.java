package padroescomportamentais.state;

import padroescomportamentais.observer.Pedido;

public class PedidoRealizado extends EstadoPedido {
    @Override
    public String realizarPedido(Pedido pedido) {
        return "Pedido já realizado.";
    }

    @Override
    public String prepararPedido(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoEmPreparo());
        return "Pedido em preparo.";
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoCancelado());
        return "Pedido cancelado.";
    }

    @Override
    public String getNomeEstado() {
        return "Realizado";
    }
}
