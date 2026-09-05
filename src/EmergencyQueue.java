package src;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    Queue<Patient> emergencyQueue = new LinkedList<>();

    public void addPatient(Patient patient) {
        emergencyQueue.add(patient);

        System.out.println(
            "Patient " + patient.patientId +
            " added to emergency queue."
        );
    }

    public Patient treatNextPatient() {

        if (emergencyQueue.isEmpty()) {
            System.out.println("No patients in emergency queue.");
            return null;
        }

        Patient patient = emergencyQueue.poll();

        System.out.println("Treating Patient:");
        patient.displayPatient();

        return patient;
    }

    public void displayQueue() {

        if (emergencyQueue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("===== EMERGENCY QUEUE =====");

        for (Patient patient : emergencyQueue) {
            System.out.println(
                "ID: " + patient.patientId +
                " | Name: " + patient.patientName +
                " | Condition: " + patient.medicalCondition
            );
        }
    }
}