package padroescomportamentais.interpreter;

public class CupomDescontoValido implements ExpressaoCupom {
    private String prefixo;

    public CupomDescontoValido(String prefixo) {
        this.prefixo = prefixo;
    }

    @Override
    public boolean interpretar(String contexto) {
        if (contexto == null) {
            return false;
        }
        return contexto.startsWith(this.prefixo);
    }
}
