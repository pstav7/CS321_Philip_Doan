package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ImmRelativeFormsTest {

    @Test
    public void testImmRelativeFormsCreation() {
        ImmRelativeForms forms = new ImmRelativeForms("F123", "2024-10-18");
        assertEquals("F123", forms.getFormID());
        assertEquals("2024-10-18", forms.getDateMade());
    }

    @Test
    public void testListAllFormsEmpty() {
        ImmRelativeForms forms = new ImmRelativeForms("F123", "2024-10-18");
        List<String> formList = forms.listAllForms();
        assertTrue(formList.isEmpty());
    }
}
