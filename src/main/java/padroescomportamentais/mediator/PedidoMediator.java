package padroescomportamentais.mediator;

import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;

public class PedidoMediator {
    private Pedido pedido;
    private Cliente cliente;

    public PedidoMediator(Pedido pedido, Cliente cliente) {
        this.pedido = pedido;
        this.cliente = cliente;
        this.pedido.addObserver(cliente);
    }

    public String solicitarPreparo() {
        this.pedido.prepararPedido();
        return "Mediator coordena preparo: Cliente " + this.cliente.getNome() + 
               " notificado do novo estado: " + this.cliente.getUltimoEstadoNotificado().getNomeEstado();
    }
}
