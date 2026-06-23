package padroescomportamentais.command;

import padroescomportamentais.observer.Pedido;

public class AguardaConfirmacaoCommand implements Command {
    private Pedido pedido;

    public AguardaConfirmacaoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean executar() {
        return this.pedido.getFormaPagamento() != null;
    }
}
