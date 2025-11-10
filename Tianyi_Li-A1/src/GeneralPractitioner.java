/**
 * General Practitioner class - extends HealthProfessional
 * Represents primary care physicians
 */
public class GeneralPractitioner extends HealthProfessional {
    // Additional instance variable - relevant to differentiate from other health professionals
    private String clinicLocation;
    private boolean acceptsNewPatients;
    
    // Default constructor
    public GeneralPractitioner() {
        super();
        this.clinicLocation = "Unknown";
        this.acceptsNewPatients = true;
    }
    
    // Second constructor that initializes all instance variables
    public GeneralPractitioner(int id, String name, String specialization, 
                              String clinicLocation, boolean acceptsNewPatients) {
        super(id, name, specialization);
        this.clinicLocation = clinicLocation;
        this.acceptsNewPatients = acceptsNewPatients;
    }
    
    // Print health professional details including type
    @Override
    public void printDetails() {
        System.out.println("=== General Practitioner Details ===");
        super.printDetails();
        System.out.println("Clinic Location: " + clinicLocation);
        System.out.println("Accepts New Patients: " + (acceptsNewPatients ? "Yes" : "No"));
        System.out.println("Type: General Practitioner");
        System.out.println("===================================");
    }
    
    // Getter and Setter methods
    public String getClinicLocation() { return clinicLocation; }
    public boolean isAcceptsNewPatients() { return acceptsNewPatients; }
    
    public void setClinicLocation(String clinicLocation) { this.clinicLocation = clinicLocation; }
    public void setAcceptsNewPatients(boolean acceptsNewPatients) { this.acceptsNewPatients = acceptsNewPatients; }
}