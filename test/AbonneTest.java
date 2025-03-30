package test;

import org.junit.jupiter.api.Test;
import serveur.service.Abonne;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbonneTest {

    @Test
    public void testAbonne() {
        Abonne a1 = new Abonne(1, "NonAdulte", LocalDate.of(2009, 3, 30));
        Abonne a2 = new Abonne(2, "Adulte", LocalDate.of(2009, 3, 29));

        assertFalse(a1.isAdulte());
        assertTrue(a2.isAdulte());
    }

}