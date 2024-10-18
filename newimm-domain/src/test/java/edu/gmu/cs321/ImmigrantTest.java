package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ImmigrantTest {

    @Test
    public void testImmigrantExists() {
        Immigrant immigrant = new Immigrant("1", "John", "Doe", "A123456789", "1990-01-01");
        assertTrue(immigrant.immigrantExist("A123456789"));
        assertFalse(immigrant.immigrantExist("A987654321"));
    }

    @Test
    public void testAddRelative() {
        Immigrant immigrant = new Immigrant("1", "John", "Doe", "A123456789", "1990-01-01");
        immigrant.addRelative("Jane Doe");
        List<String> relatives = immigrant.listRelatives();

        assertEquals(1, relatives.size());
        assertTrue(relatives.contains("Jane Doe"));
    }

    @Test
    public void testListRelativesEmpty() {
        Immigrant immigrant = new Immigrant("1", "John", "Doe", "A123456789", "1990-01-01");
        assertTrue(immigrant.listRelatives().isEmpty());
    }
}
