package edu.gmu.cs321;

import java.util.ArrayList;
import java.util.List;

public class Immigrant extends Person {
    private String aNumberImm;
    private String dob;
    private List<String> relatives;

    // Constructor
    public Immigrant(String id, String firstName, String lastName, String aNumberImm, String dob) {
        super(id, firstName, lastName);
        this.aNumberImm = aNumberImm;
        this.dob = dob;
        this.relatives = new ArrayList<>();
    }

    // Method to add an immigrant (example functionality)
    public void addImmigrant(String aNumber, String name, int age) {
        // Implementation for adding immigrant can be more complex
        // Here, it's just an example
    }

    // Method to check if an immigrant exists based on A-Number
    public boolean immigrantExist(String aNumber) {
        return this.aNumberImm.equals(aNumber);
    }

    // Method to list all relatives
    public List<String> listRelatives() {
        return new ArrayList<>(this.relatives);
    }

    // Method to add a relative
    public void addRelative(String relativeName) {
        if (relativeName != null && !relativeName.trim().isEmpty()) {
            this.relatives.add(relativeName);
        }
    }

    // Getters and setters
    public String getANumberImm() {
        return aNumberImm;
    }

    public void setANumberImm(String aNumberImm) {
        this.aNumberImm = aNumberImm;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
