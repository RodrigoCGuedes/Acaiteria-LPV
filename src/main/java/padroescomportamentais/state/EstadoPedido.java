package padroescomportamentais.state;

import padroescomportamentais.observer.Pedido;

public abstract class EstadoPedido {
    public String realizarPedido(Pedido pedido) {
        return "Transição não permitida";
    }
    public String prepararPedido(Pedido pedido) {
        return "Transição não permitida";
    }
    public String concluirPedido(Pedido pedido) {
        return "Transição não permitida";
    }
    public String cancelarPedido(Pedido pedido) {
        return "Transição não permitida";
    }
    public abstract String getNomeEstado();
}
