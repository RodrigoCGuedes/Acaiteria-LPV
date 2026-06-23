package padroescomportamentais.interpreter;

public class CupomDescontoExpirado implements ExpressaoCupom {
    private String sufixoExpirado;

    public CupomDescontoExpirado(String sufixoExpirado) {
        this.sufixoExpirado = sufixoExpirado;
    }

    @Override
    public boolean interpretar(String contexto) {
        if (contexto == null) {
            return false;
        }
        return contexto.endsWith(this.sufixoExpirado);
    }
}
