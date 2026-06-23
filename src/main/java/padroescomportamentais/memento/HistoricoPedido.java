package padroescomportamentais.memento;

import java.util.Stack;
import padroescomportamentais.observer.Pedido;

public class HistoricoPedido {
    private Stack<PedidoMemento> historico = new Stack<>();

    public void salvarEstado(Pedido pedido) {
        this.historico.push(pedido.salvar());
    }

    public void restaurarEstado(Pedido pedido) {
        if (!this.historico.isEmpty()) {
            pedido.restaurar(this.historico.pop());
        }
    }

    public int getQtdEstadosSalvos() {
        return this.historico.size();
    }
}
