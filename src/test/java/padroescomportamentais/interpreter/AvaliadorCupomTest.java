package padroescomportamentais.interpreter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AvaliadorCupomTest {
    @Test
    void deveAceitarCupomValidoENaoExpirado() {
        CupomDescontoValido valido = new CupomDescontoValido("CUPOM");
        CupomDescontoExpirado expirado = new CupomDescontoExpirado("EXP");
        AvaliadorCupom avaliador = new AvaliadorCupom(valido, expirado);

        assertTrue(avaliador.interpretar("CUPOM10"));
        assertTrue(avaliador.interpretar("CUPOM50NEW"));
    }

    @Test
    void deveRecusarCupomExpirado() {
        CupomDescontoValido valido = new CupomDescontoValido("CUPOM");
        CupomDescontoExpirado expirado = new CupomDescontoExpirado("EXP");
        AvaliadorCupom avaliador = new AvaliadorCupom(valido, expirado);

        assertFalse(avaliador.interpretar("CUPOM10EXP"));
    }

    @Test
    void deveRecusarCupomInvalido() {
        CupomDescontoValido valido = new CupomDescontoValido("CUPOM");
        CupomDescontoExpirado expirado = new CupomDescontoExpirado("EXP");
        AvaliadorCupom avaliador = new AvaliadorCupom(valido, expirado);

        assertFalse(avaliador.interpretar("DESCONTO10"));
    }
}
