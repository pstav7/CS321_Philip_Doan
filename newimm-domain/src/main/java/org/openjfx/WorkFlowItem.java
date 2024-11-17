package org.openjfx;

public class WorkFlowItem {
    private String formId;
    private String nextStep;

    // Constructor
    public WorkFlowItem(String formId, String nextStep) {
        this.formId = formId;
        this.nextStep = nextStep;
    }

    // Getters
    public String getFormId() {
        return formId;
    }

    public String getNextStep() {
        return nextStep;
    }
}
