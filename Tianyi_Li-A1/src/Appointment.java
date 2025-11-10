import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Appointment class - handles patient appointments
 */
public class Appointment {
    // Patient details
    private String patientName;
    private String patientMobile;
    
    // Preferred time slot
    private String timeSlot;
    
    // Selected doctor - using polymorphism, can be any HealthProfessional subclass
    private HealthProfessional selectedDoctor;
    
    // Default constructor
    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "Unknown";
        this.timeSlot = "09:00";
        this.selectedDoctor = null;
    }
    
    // Second constructor that initializes all instance variables
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional selectedDoctor) {
        // Validate mobile number format
        if (!isValidMobile(patientMobile)) {
            throw new IllegalArgumentException("Invalid mobile number format. Must be 10-15 digits.");
        }
        
        // Validate time slot format
        if (!isValidTimeSlot(timeSlot)) {
            throw new IllegalArgumentException("Invalid time slot format. Must be HH:MM (00:00-23:59).");
        }
        
        if (selectedDoctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null.");
        }
        
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.selectedDoctor = selectedDoctor;
    }
    
    // Print all instance variables
    public void printAppointmentDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient: " + patientName);
        System.out.println("Mobile: " + patientMobile);
        System.out.println("Time: " + timeSlot);
        System.out.println("Doctor Information:");
        if (selectedDoctor != null) {
            selectedDoctor.printDetails();
        } else {
            System.out.println("  Doctor: Not assigned");
        }
        System.out.println("-------------------");
    }
    
    // Validate mobile number format
    private boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("\\d{10,15}");
    }
    
    // Validate time slot format - FIXED: removed unused variable
    private boolean isValidTimeSlot(String timeSlot) {
        try {
            // Directly parse without storing in a variable
            LocalTime.parse(timeSlot, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    // Getter methods
    public String getPatientName() { return patientName; }
    public String getPatientMobile() { return patientMobile; }
    public String getTimeSlot() { return timeSlot; }
    public HealthProfessional getSelectedDoctor() { return selectedDoctor; }
    
    // Setter methods
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setPatientMobile(String patientMobile) { 
        if (isValidMobile(patientMobile)) {
            this.patientMobile = patientMobile;
        } else {
            throw new IllegalArgumentException("Invalid mobile number format.");
        }
    }
    public void setTimeSlot(String timeSlot) { 
        if (isValidTimeSlot(timeSlot)) {
            this.timeSlot = timeSlot;
        } else {
            throw new IllegalArgumentException("Invalid time slot format.");
        }
    }
    public void setSelectedDoctor(HealthProfessional selectedDoctor) { 
        if (selectedDoctor != null) {
            this.selectedDoctor = selectedDoctor;
        } else {
            throw new IllegalArgumentException("Doctor cannot be null.");
        }
    }
}