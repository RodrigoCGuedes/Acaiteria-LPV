package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class EnderecoFactory {
    private static EnderecoFactory instance;
    private Map<String, EnderecoFlyWeight> enderecos = new HashMap<>();

    private EnderecoFactory() {}

    public static synchronized EnderecoFactory getInstance() {
        if (instance == null) {
            instance = new EnderecoFactory();
        }
        return instance;
    }

    public EnderecoFlyWeight getEndereco(String uf, String cidade) {
        String chave = uf + "-" + cidade;
        if (!enderecos.containsKey(chave)) {
            enderecos.put(chave, new EnderecoFlyWeight(uf, cidade));
        }
        return enderecos.get(chave);
    }

    public int getQtdEnderecosArmazenados() {
        return this.enderecos.size();
    }

    public void clear() {
        this.enderecos.clear();
    }
}
