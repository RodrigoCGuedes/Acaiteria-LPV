package padroescomportamentais.command;

import padroescomportamentais.observer.Pedido;
import padroescomportamentais.state.PedidoEmPreparo;

public class AceitaPedidoCommand implements Command {
    private Pedido pedido;

    public AceitaPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean executar() {
        this.pedido.prepararPedido();
        return this.pedido.getEstadoPedido() instanceof PedidoEmPreparo;
    }
}
