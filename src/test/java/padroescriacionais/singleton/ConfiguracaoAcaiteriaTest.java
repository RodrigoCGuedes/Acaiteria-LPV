package padroescriacionais.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoAcaiteriaTest {
    @Test
    void deveRetornarMesmaInstanciaSingleton() {
        ConfiguracaoAcaiteria c1 = ConfiguracaoAcaiteria.getInstance();
        ConfiguracaoAcaiteria c2 = ConfiguracaoAcaiteria.getInstance();

        assertSame(c1, c2);
    }

    @Test
    void deveAlterarNomeLojaNasDuasReferencias() {
        ConfiguracaoAcaiteria c1 = ConfiguracaoAcaiteria.getInstance();
        ConfiguracaoAcaiteria c2 = ConfiguracaoAcaiteria.getInstance();

        c1.setNomeLoja("Nova Açaiteria");
        assertEquals("Nova Açaiteria", c2.getNomeLoja());
    }
}
