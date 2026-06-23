package padroescriacionais.abstractfactory;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import padroesestruturais.decorator.AcaiBase;
import padroesestruturais.decorator.CaldaMorango;
import padroesestruturais.decorator.Granola;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryComboTest {
    @Test
    void deveCriarComboZeroComCaldaMorango() {
        LocalDateTime limite = LocalDateTime.of(2026, 12, 31, 23, 59);
        AcaiZeroFactory factory = new AcaiZeroFactory(true, limite);

        assertTrue(factory.isAtivo());
        assertEquals(limite, factory.getDataLimiteUso());

        AcaiBase base = factory.definirTipoAcaiBase();
        assertEquals("Açaí Zero Açúcar", base.getDescricao());
        assertEquals("Zero", base.getTipo());

        CaldaMorango decorator = (CaldaMorango) factory.definirAdicional(new CaldaMorango(base));
        assertNotNull(decorator);
        assertEquals("Açaí Zero Açúcar, Calda de Morango, Calda de Morango", decorator.getDescricao());
    }

    @Test
    void deveCriarComboPremiumComGranola() {
        LocalDateTime limite = LocalDateTime.of(2026, 12, 31, 23, 59);
        AcaiPremiumFactory factory = new AcaiPremiumFactory(false, limite);

        assertFalse(factory.isAtivo());
        assertEquals(limite, factory.getDataLimiteUso());

        AcaiBase base = factory.definirTipoAcaiBase();
        assertEquals("Açaí de Banana", base.getDescricao());
        assertEquals("Banana", base.getTipo());

        Granola decorator = (Granola) factory.definirAdicional(new Granola(base));
        assertNotNull(decorator);
        assertEquals("Açaí de Banana, Granola, Granola", decorator.getDescricao());
    }
}
