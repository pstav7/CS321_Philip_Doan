package org.openjfx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkflowDatabase {

    // Method to check if a form already exists in the database
    public static boolean doesFormExist(int formId) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT COUNT(*) FROM workflow_forms WHERE form_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, formId); // Set the form ID as the parameter
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        return true; // If form exists, return true
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error checking if form exists: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // If no form exists, return false
    }

    // Method to insert a new workflow item into the database
    public static void addWorkflowItem(String formId, String nextStep) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO workflow_forms (form_id, next_step, status) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, Integer.parseInt(formId));  // Set form ID
                stmt.setString(2, nextStep);  // Set next step
                stmt.setString(3, "Pending");  // Default status is 'Pending'
                stmt.executeUpdate();
                System.out.println("Form successfully inserted into the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting workflow item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to get the next workflow item (e.g., form) based on status
    public static String getNextWorkflowItem(String status) throws SQLException {
        String nextFormId = null;
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT TOP 1 form_id FROM workflow_forms WHERE status = ?"; // Replaced LIMIT with TOP 1 for SQL Server compatibility
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, status); // Set the status as 'Pending' or 'Review'
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        nextFormId = String.valueOf(rs.getInt("form_id"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching next workflow item: " + e.getMessage());
            e.printStackTrace();
        }
        return nextFormId;
    }

    // Method to update the status of a workflow item
    public static void updateWorkflowStatus(int formId, String status) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "UPDATE workflow_forms SET status = ? WHERE form_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, status);
                stmt.setInt(2, formId);
                stmt.executeUpdate(); // Execute update query
            }
        } catch (SQLException e) {
            System.err.println("Error updating workflow status: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
