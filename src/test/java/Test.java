package com.groupeisi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorielleTest {

    private final Factoriel factorielle = new Factoriel();

    @Test
    void testFactorielleZero() {
        assertEquals(1, factorielle.calculerFactorielle(0), "La factorielle de 0 doit être 1.");
    }

    @Test
    void testFactoriellePositive() {
        assertEquals(120, factorielle.calculerFactorielle(5), "La factorielle de 5 doit être 120.");
    }

    @Test
    void testFactorielleUn() {
        assertEquals(1, factorielle.calculerFactorielle(1), "La factorielle de 1 doit être 1.");
    }

    @Test
    void testFactorielleGrandNombre() {
        assertEquals(3628800, factorielle.calculerFactorielle(10), "La factorielle de 10 doit être 3,628,800.");
    }

    @Test
    void testFactorielleNegative() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> factorielle.calculerFactorielle(-5),
                "Une exception doit être lancée pour un nombre négatif.");

        assertEquals("Le nombre ne peut pas être négatif.", thrown.getMessage());
    }
}
