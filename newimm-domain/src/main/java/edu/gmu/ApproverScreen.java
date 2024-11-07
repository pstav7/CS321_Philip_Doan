package edu.gmu.cs321;

public class ApproverScreen {

    // Method to display the Approver screen
    public void displayApproverScreen() {
        //Pop the screen up
        
    }

    /**
     * Print welcome messsage after approver log in
     */
    public void printWelcomeMessage(String name) {
        System.out.println("Welcome! Approver" + name);
    }

    /**
     * Screen print error to approver depending on the type.
     * Display the type of message.
     */
    public void printErrorMessage() {
        System.err.println("Error");
    }

    /**
     * Authorize the form or reject it with comments.
     */
    public boolean SetAuthorizationtoForm(NewImmform form) {
        boolean flag = false;
        //If database validated ALL information, all information presented
        // Authorize
        if(true) {
            flag= true;
        }

        return flag;
    }
    
}
