package padroesestruturais.flyweight;

public class EnderecoFlyWeight {
    private String uf;
    private String cidade;

    public EnderecoFlyWeight(String uf, String cidade) {
        this.uf = uf;
        this.cidade = cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public String getCidade() {
        return this.cidade;
    }
}
