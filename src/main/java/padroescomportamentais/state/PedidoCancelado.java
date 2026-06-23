package padroescomportamentais.state;

import padroescomportamentais.observer.Pedido;

public class PedidoCancelado extends EstadoPedido {
    @Override
    public String getNomeEstado() {
        return "Cancelado";
    }
}
