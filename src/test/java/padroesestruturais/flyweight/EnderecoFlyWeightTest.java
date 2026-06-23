package padroesestruturais.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnderecoFlyWeightTest {
    @Test
    void deveCompartilharInstanciasFlyweight() {
        EnderecoFactory factory = EnderecoFactory.getInstance();
        factory.clear();
        
        EnderecoFlyWeight fw1 = factory.getEndereco("MG", "Juiz de Fora");
        EnderecoFlyWeight fw2 = factory.getEndereco("MG", "Juiz de Fora");
        EnderecoFlyWeight fw3 = factory.getEndereco("SP", "São Paulo");

        assertSame(fw1, fw2);
        assertNotSame(fw1, fw3);
        assertEquals(2, factory.getQtdEnderecosArmazenados());
    }

    @Test
    void deveRetornarEnderecoCompleto() {
        EnderecoFactory factory = EnderecoFactory.getInstance();
        factory.clear();
        EnderecoFlyWeight fw = factory.getEndereco("RJ", "Rio de Janeiro");
        Endereco endereco = new Endereco("20000-000", "Av. Atlântica", "Apto 101", "Copacabana", fw);

        assertEquals("Av. Atlântica, Copacabana, Rio de Janeiro - RJ (CEP: 20000-000)", endereco.getEnderecoCompleto());
    }
}
