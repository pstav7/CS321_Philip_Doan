package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImmigrantTest {

    @Test
    public void testCheckANum() {
        assertTrue(Immigrant.checkANum("A123456789"));  // valid A-Number
        assertFalse(Immigrant.checkANum("123456789"));  // invalid A-Number (no 'A')
        assertFalse(Immigrant.checkANum("A12345"));     // invalid A-Number (too short)
    }

    @Test
    public void testIsAdult() {
        Immigrant adult = new Immigrant("A123456789", "John Doe", 25);
        Immigrant child = new Immigrant("A987654321", "Jane Doe", 17);
        
        assertTrue(adult.isAdult());    // adult should be true
        assertFalse(child.isAdult());   // child should be false
    }

    @Test
    public void testIsValidName() {
        Immigrant validImmigrant = new Immigrant("A123456789", "John Doe", 25);
        Immigrant invalidImmigrant = new Immigrant("A987654321", "", 25);
        Immigrant nullNameImmigrant = new Immigrant("A123456780", null, 25);

        assertTrue(validImmigrant.isValidName());      // valid name
        assertFalse(invalidImmigrant.isValidName());   // empty name
        assertFalse(nullNameImmigrant.isValidName());  // null name
    }

    @Test
    public void testGetters() {
        Immigrant immigrant = new Immigrant("A123456789", "John Doe", 25);
        
        assertEquals("A123456789", immigrant.getaNum());
        assertEquals("John Doe", immigrant.getName());
        assertEquals(25, immigrant.getAge());
    }
}
