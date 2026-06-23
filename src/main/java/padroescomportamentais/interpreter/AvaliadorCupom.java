package padroescomportamentais.interpreter;

public class AvaliadorCupom implements ExpressaoCupom {
    private ExpressaoCupom valido;
    private ExpressaoCupom expirado;

    public AvaliadorCupom(ExpressaoCupom valido, ExpressaoCupom expirado) {
        this.valido = valido;
        this.expirado = expirado;
    }

    @Override
    public boolean interpretar(String contexto) {
        return this.valido.interpretar(contexto) && !this.expirado.interpretar(contexto);
    }
}
