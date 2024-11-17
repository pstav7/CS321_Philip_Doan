package edu.gmu.cs321;

import com.cs321.Workflow;
import java.sql.SQLException;
import org.openjfx.WorkflowDatabase;

public class WorkflowIntegration {
    private Workflow workflow;

    // Constructor initializes the Workflow object
    public WorkflowIntegration() {
        this.workflow = new Workflow();
    }

    // Fetch the next form for review or approval
    public String reviewNextForm() throws SQLException {
        // Fetch the next form with status 'Pending' or 'Review'
        return WorkflowDatabase.getNextWorkflowItem("Pending"); // Modify status as needed
    }

    // Submit a form to the workflow and store it in the database
    public void submitForm(String formId, String nextStep) throws SQLException {
        try {
            // Check if the form already exists in the workflow_forms table
            if (WorkflowDatabase.doesFormExist(Integer.parseInt(formId))) {
                System.out.println("Form with ID " + formId + " already exists.");
                return;
            }

            // Add the form to the workflow system
            int workflowResult = workflow.AddWFItem(Integer.parseInt(formId), nextStep);
            if (workflowResult == 0) {
                // If successful, store the form in the database
                WorkflowDatabase.addWorkflowItem(formId, nextStep);
                System.out.println("Form successfully added to workflow.");
            } else {
                System.err.println("Failed to add form. API returned code: " + workflowResult);
                throw new IllegalArgumentException("Error adding to Workflow API: Code " + workflowResult);
            }
        } catch (Exception e) {
            System.err.println("Exception during form submission: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update form status (e.g., from 'Pending' to 'Reviewed' or 'Approved')
    public void updateFormStatus(String formId, String newStatus) throws SQLException {
        try {
            WorkflowDatabase.updateWorkflowStatus(Integer.parseInt(formId), newStatus);
            System.out.println("Form status updated to: " + newStatus);
        } catch (SQLException e) {
            System.err.println("Error updating form status: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
