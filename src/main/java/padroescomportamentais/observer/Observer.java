package padroescomportamentais.observer;

import padroescomportamentais.state.EstadoPedido;

public interface Observer {
    void atualizar(EstadoPedido estado);
}
