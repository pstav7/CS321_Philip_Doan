package edu.gmu.cs321;

public class Workflow {
    private String wfid;
    private String formID;
    private String nextID;
    private boolean finished;

    // Constructor
    public Workflow(String wfid, String formID, String nextID, boolean finished) {
        this.wfid = wfid;
        this.formID = formID;
        this.nextID = nextID;
        this.finished = finished;
    }

    // Method to add a workflow item
    public String addWFItem(String formID, String nextStep) {
        // Add workflow item logic here
        return formID;
    }

    // Method to get the next item in the workflow
    public String getNextItem(String nextStep) {
        // Logic for retrieving next item here
        return formID;
    }

    // Getters and setters
    public String getWfid() {
        return wfid;
    }

    public void setWfid(String wfid) {
        this.wfid = wfid;
    }

    public String getFormID() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    public String getNextID() {
        return nextID;
    }

    public void setNextID(String nextID) {
        this.nextID = nextID;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
