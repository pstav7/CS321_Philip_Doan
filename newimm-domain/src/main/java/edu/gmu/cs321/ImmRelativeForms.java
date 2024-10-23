package edu.gmu.cs321;

import java.util.ArrayList;
import java.util.List;

public class ImmRelativeForms {
    private String formID;
    private String dateMade;
    private List<String> formStorage;

    // Constructor
    public ImmRelativeForms(String formID, String dateMade) {
        this.formID = formID;
        this.dateMade = dateMade;
        this.formStorage = new ArrayList<>();
    }

    // Method to list all forms
    public List<String> listAllForms() {
        return new ArrayList<>(formStorage);
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
