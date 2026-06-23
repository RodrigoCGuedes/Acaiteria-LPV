package padroescomportamentais.iterator;

import padroesestruturais.decorator.Produto;

public interface Iterator {
    boolean temProximo();
    Produto proximo();
}
