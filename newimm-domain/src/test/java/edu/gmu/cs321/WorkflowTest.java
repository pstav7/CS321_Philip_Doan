package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WorkflowTest {

    @Test
    public void testWorkflowCreation() {
        Workflow workflow = new Workflow("WF1", "F123", "Next123", false);
        assertEquals("WF1", workflow.getWfid());
        assertEquals("F123", workflow.getFormID());
        assertEquals("Next123", workflow.getNextID());
        assertFalse(workflow.isFinished());
    }

    @Test
    public void testSetters() {
        Workflow workflow = new Workflow("WF1", "F123", "Next123", false);
        workflow.setWfid("WF2");
        workflow.setFormID("F124");
        workflow.setNextID("Next124");
        workflow.setFinished(true);

        assertEquals("WF2", workflow.getWfid());
        assertEquals("F124", workflow.getFormID());
        assertEquals("Next124", workflow.getNextID());
        assertTrue(workflow.isFinished());
    }
}
