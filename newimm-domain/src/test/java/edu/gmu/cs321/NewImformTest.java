package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NewImformTest {

    @Test
    public void testNewImmFormCreation() {
        // Corrected the class name to NewImmForm and provided a variable name (form)
        NewImmform form = new NewImmform("F123", "2024-10-18");
        assertEquals("F123", form.getFormID());
        assertEquals("2024-10-18", form.getDateMade());
    }

    @Test
    public void testSetters() {
        NewImmform form = new NewImmform("F123", "2024-10-18");
        form.setFormID("F124");
        form.setDateMade("2024-11-01");

        assertEquals("F124", form.getFormID());
        assertEquals("2024-11-01", form.getDateMade());
    }
}
