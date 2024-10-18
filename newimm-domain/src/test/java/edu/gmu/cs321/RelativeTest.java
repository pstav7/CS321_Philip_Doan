package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RelativeTest {

    @Test
    public void testRelativeCreation() {
        Relative relative = new Relative("A123456789");
        assertEquals("A123456789", relative.getANumberImm());
    }

    @Test
    public void testSetANumberImm() {
        Relative relative = new Relative("A123456789");
        relative.setANumberImm("A987654321");
        assertEquals("A987654321", relative.getANumberImm());
    }
}
