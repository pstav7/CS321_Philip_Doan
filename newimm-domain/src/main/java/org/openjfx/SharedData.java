package org.openjfx;

public class SharedData {
    private static SharedData instance;
    private String immigrantANumber;
    private String relativeANumber;

    private SharedData() {
        // Private constructor for singleton
    }

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public String getImmigrantANumber() {
        return immigrantANumber;
    }

    public void setImmigrantANumber(String immigrantANumber) {
        this.immigrantANumber = immigrantANumber;
    }

    public String getRelativeANumber() {
        return relativeANumber;
    }

    public void setRelativeANumber(String relativeANumber) {
        this.relativeANumber = relativeANumber;
    }
}
