/**
 * Base class for Health Professionals
 * Common attributes and behaviors for all medical professionals
 */
public class HealthProfessional {
    // Required instance variables
    private int id;  // Numbers only
    private String name;
    private String specialization; // Relevant basic information
    
    // Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.specialization = "General";
    }
    
    // Second constructor that initializes all instance variables
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
    
    // Method to print all instance variables
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
    
    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    
    // Setter methods
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}