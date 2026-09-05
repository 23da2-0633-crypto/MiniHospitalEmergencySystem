package src;

import java.util.Stack;

public class TreatmentHistory {

    Stack<Patient> history = new Stack<>();

    // Add treated patient to history
    public void addToHistory(Patient patient) {
        history.push(patient);
        System.out.println("Patient " + patient.patientId
                + " added to treatment history.");
    }

    // Display treatment history
    public void displayHistory() {

        if (history.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("===== TREATMENT HISTORY =====");

        for (int i = history.size() - 1; i >= 0; i--) {
            Patient patient = history.get(i);

            System.out.println(
                "ID: " + patient.patientId +
                " | Name: " + patient.patientName +
                " | Condition: " + patient.medicalCondition
            );
        }
    }
}