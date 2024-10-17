package edu.gmu.cs321;

public class Immigrant {
    private String aNum;
    private String name;
    private int age;

    // Constructor
    public Immigrant(String aNum, String name, int age) {
        this.aNum = aNum;
        this.name = name;
        this.age = age;
    }

    // Method to check if A-Number is valid (A-Number starts with 'A' and has 9 digits)
    public static boolean checkANum(String anumid) {
        return anumid.matches("A\\d{9}");
    }

    // Method to check if immigrant is an adult (18 or older)
    public boolean isAdult() {
        return this.age >= 18;
    }

    // Method to check if the name is valid (should not be empty or null)
    public boolean isValidName() {
        return this.name != null && !this.name.trim().isEmpty();
    }

    // Getter for the A-Number
    public String getaNum() {
        return this.aNum;
    }

    // Getter for the name
    public String getName() {
        return this.name;
    }

    // Getter for the age
    public int getAge() {
        return this.age;
    }
}
