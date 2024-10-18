package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImmigrantApplicantValidationTest {

    @Test
    public void testValidationStatus() {
        ImmigrantApplicantValidation validation = new ImmigrantApplicantValidation(false);
        assertFalse(validation.isValidated());
        validation.setValidated(true);
        assertTrue(validation.isValidated());
    }

    @Test
    public void testValidateNewImm() {
        ImmigrantApplicantValidation validation = new ImmigrantApplicantValidation(false);
        // Assuming the validateNewImm method logic sets the status
        assertFalse(validation.validateNewImm());
    }
}
