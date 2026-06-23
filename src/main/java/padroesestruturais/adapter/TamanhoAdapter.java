package padroesestruturais.adapter;

public class TamanhoAdapter implements ITamanho {
    private TamanhoCopo tamanhoCopo;

    public TamanhoAdapter(TamanhoCopo tamanhoCopo) {
        this.tamanhoCopo = tamanhoCopo;
    }

    @Override
    public String getTamanho() {
        return this.tamanhoCopo.getQtdMl() + "ml";
    }
}
