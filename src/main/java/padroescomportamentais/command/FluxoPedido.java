package padroescomportamentais.command;

import java.util.ArrayList;
import java.util.List;

public class FluxoPedido {
    private List<Command> comandos = new ArrayList<>();

    public void adicionarComando(Command comando) {
        this.comandos.add(comando);
    }

    public boolean executarFluxo() {
        for (Command comando : this.comandos) {
            if (!comando.executar()) {
                return false;
            }
        }
        return true;
    }
}
