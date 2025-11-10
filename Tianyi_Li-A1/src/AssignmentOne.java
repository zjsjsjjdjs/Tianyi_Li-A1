import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main class - contains main method and program entry point
 * Demonstrates complete functionality of the healthcare appointment system
 */
public class AssignmentOne {
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Healthcare Appointment System Demonstration ===\n");
        
        // Part 3 – Using classes and objects
        System.out.println("// Part 3 – Using classes and objects");
        demonstrateInheritance();
        
        System.out.println("---");
        
        // Part 5 – Collection of appointments
        System.out.println("// Part 5 – Collection of appointments");
        demonstrateAppointmentSystem();
        
        System.out.println("---");
        System.out.println("=== Demonstration Complete ===");
    }
    
    /**
     * Demonstrate inheritance concept - create different types of doctors and display information
     */
    private static void demonstrateInheritance() {
        System.out.println("\n--- Creating Health Professionals ---");
        
        // Create three General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Sarah Wilson", "Family Medicine", 
                                                         "Main Street Clinic", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Michael Brown", "General Practice", 
                                                         "City Health Center", false);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Emily Chen", "Primary Care", 
                                                         "Northside Medical", true);
        
        // Create two Surgeon objects
        Surgeon surgeon1 = new Surgeon(201, "Dr. James Smith", "Cardiovascular Surgery", 
                                      "Heart Surgery", 15);
        Surgeon surgeon2 = new Surgeon(202, "Dr. Lisa Johnson", "Orthopedic Surgery", 
                                      "Joint Replacement", 8);
        
        // Print details of all health professionals
        System.out.println("\n--- General Practitioner Information ---");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        
        System.out.println("\n--- Surgeon Information ---");
        surgeon1.printDetails();
        surgeon2.printDetails();
        
        // Demonstrate polymorphism
        System.out.println("\n--- Polymorphism Demonstration ---");
        HealthProfessional[] professionals = {
            new GeneralPractitioner(104, "Dr. Robert Taylor", "General Practice", "Southside Clinic", true),
            new Surgeon(203, "Dr. Maria Garcia", "Neurosurgery", "Brain Surgery", 12)
        };
        
        for (HealthProfessional professional : professionals) {
            professional.printDetails(); // Same call, different behavior!
        }
    }
    
    /**
     * Demonstrate appointment system functionality
     */
    private static void demonstrateAppointmentSystem() {
        // Create some doctors for appointments
        GeneralPractitioner demoGP = new GeneralPractitioner(301, "Demo GP Doctor", "General Practice", 
                                                           "Demo Clinic", true);
        Surgeon demoSurgeon = new Surgeon(302, "Demo Surgeon", "Surgery", 
                                        "Demo Surgery", 10);
        
        System.out.println("\n--- Appointment Management Demonstration ---");
        
        // Create appointments
        System.out.println("\nCreating appointments...");
        createAppointment("John Smith", "0412345678", "09:00", demoGP);
        createAppointment("Jane Doe", "0498765432", "10:30", demoGP);
        createAppointment("Bob Wilson", "0432156789", "14:00", demoSurgeon);
        createAppointment("Alice Brown", "0444555666", "15:30", demoSurgeon);
        
        // Display all appointments
        System.out.println("\nCurrent Appointments:");
        printExistingAppointments();
        
        // Cancel one appointment
        System.out.println("\nCanceling appointment...");
        cancelBooking("0498765432");
        
        // Display updated appointments
        System.out.println("\nUpdated Appointment List:");
        printExistingAppointments();
        
        // Demonstrate error handling
        System.out.println("\n--- Error Handling Demonstration ---");
        createAppointment("Test Patient", "123", "09:00", demoGP);        // Invalid mobile
        createAppointment("Test Patient", "0411111111", "25:00", demoGP); // Invalid time
    }
    
    /**
     * Create new appointment and add to ArrayList
     * Uses polymorphism to handle different types of health professionals
     */
    public static void createAppointment(String patientName, String patientMobile, 
                                       String timeSlot, HealthProfessional doctor) {
        try {
            Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
            appointments.add(newAppointment);
            System.out.println("✓ Appointment created successfully: " + patientName + " -> " + doctor.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Appointment creation failed: " + e.getMessage());
        }
    }
    
    /**
     * Display existing appointments in ArrayList
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No current appointments.");
            return;
        }
        
        System.out.println("Total Appointments: " + appointments.size());
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("Appointment #" + (i + 1) + ":");
            appointments.get(i).printAppointmentDetails();
        }
    }
    
    /**
     * Cancel booking using patient's mobile number
     */
    public static void cancelBooking(String patientMobile) {
        Iterator<Appointment> iterator = appointments.iterator();
        boolean found = false;
        
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getPatientMobile().equals(patientMobile)) {
                iterator.remove();
                System.out.println("✓ Appointment canceled for mobile: " + patientMobile);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("✗ No appointment found for mobile: " + patientMobile);
        }
    }
}