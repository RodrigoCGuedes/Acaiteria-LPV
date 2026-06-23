package padroesestruturais.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TamanhoAdapterTest {
    @Test
    void deveRetornarTamanhoFormatadoEmMl() {
        TamanhoCopo copo = new TamanhoCopo(500);
        ITamanho adapter = new TamanhoAdapter(copo);
        assertEquals("500ml", adapter.getTamanho());
    }
}
