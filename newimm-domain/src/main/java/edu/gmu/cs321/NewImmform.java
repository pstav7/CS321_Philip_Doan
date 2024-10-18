package edu.gmu.cs321;

public class NewImmform{
    private String formID;
    private String dateMade;

    // Constructor
    public NewImmform(String formID, String dateMade) {
        this.formID = formID;
        this.dateMade = dateMade;
    }

    // Method to add a new immigration form
    public void addNewImmForm(String formID, String dateMade) {
        // Implementation can be based on adding to a collection or database
    }

    // Getters and setters
    public String getFormID() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    public String getDateMade() {
        return dateMade;
    }

    public void setDateMade(String dateMade) {
        this.dateMade = dateMade;
    }
}
