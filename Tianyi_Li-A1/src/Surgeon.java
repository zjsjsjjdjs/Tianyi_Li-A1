/**
 * Surgeon class - extends HealthProfessional
 * Represents specialist surgeons
 */
public class Surgeon extends HealthProfessional {
    // Additional instance variable - relevant to differentiate from other health professionals
    private String surgeryType;
    private int yearsOfExperience;
    
    // Default constructor
    public Surgeon() {
        super();
        this.surgeryType = "General Surgery";
        this.yearsOfExperience = 0;
    }
    
    // Second constructor that initializes all instance variables
    public Surgeon(int id, String name, String specialization, 
                   String surgeryType, int yearsOfExperience) {
        super(id, name, specialization);
        this.surgeryType = surgeryType;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    // Print health professional details including type
    @Override
    public void printDetails() {
        System.out.println("=== Surgeon Details ===");
        super.printDetails();
        System.out.println("Surgery Type: " + surgeryType);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Type: Surgeon");
        System.out.println("=======================");
    }
    
    // Method specific to surgeons
    public boolean isSeniorSurgeon() {
        return yearsOfExperience >= 10;
    }
    
    // Getter and Setter methods
    public String getSurgeryType() { return surgeryType; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}