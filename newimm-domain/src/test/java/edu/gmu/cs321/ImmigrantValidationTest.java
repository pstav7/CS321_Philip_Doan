package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImmigrantValidationTest {

    @Test
    public void testValidationStatus() {
        ImmigrantValidation validation = new ImmigrantValidation(false);
        assertFalse(validation.isValidated());
        validation.setValidated(true);
        assertTrue(validation.isValidated());
    }

    @Test
    public void testValidateNewImm() {
        ImmigrantValidation validation = new ImmigrantValidation(false);
        // Assuming the validateNewImm method logic sets the status
        assertFalse(validation.validateNewImm());
    }
}
