package padroesestruturais.flyweight;

public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private EnderecoFlyWeight flyweight;

    public Endereco(String cep, String rua, String complemento, String bairro, EnderecoFlyWeight flyweight) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.flyweight = flyweight;
    }

    public String getCep() {
        return this.cep;
    }

    public String getRua() {
        return this.rua;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public EnderecoFlyWeight getFlyweight() {
        return this.flyweight;
    }

    public String getEnderecoCompleto() {
        return this.rua + ", " + this.bairro + ", " + this.flyweight.getCidade() + " - " + this.flyweight.getUf() + " (CEP: " + this.cep + ")";
    }
}
