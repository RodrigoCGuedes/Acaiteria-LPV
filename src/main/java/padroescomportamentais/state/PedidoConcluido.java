package padroescomportamentais.state;

import padroescomportamentais.observer.Pedido;

public class PedidoConcluido extends EstadoPedido {
    @Override
    public String getNomeEstado() {
        return "Concluído";
    }
}
