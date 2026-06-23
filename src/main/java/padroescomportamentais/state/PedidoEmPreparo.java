package padroescomportamentais.state;

import padroescomportamentais.observer.Pedido;

public class PedidoEmPreparo extends EstadoPedido {
    @Override
    public String concluirPedido(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoConcluido());
        return "Pedido concluído.";
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoCancelado());
        return "Pedido cancelado.";
    }

    @Override
    public String getNomeEstado() {
        return "Em Preparo";
    }
}
