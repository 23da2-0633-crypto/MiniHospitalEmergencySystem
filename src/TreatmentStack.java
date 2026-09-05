package src;

import java.util.Stack;

public class TreatmentStack {

    Stack<Patient> treatmentHistory = new Stack<>();

    public void addTreatment(Patient patient) {
        treatmentHistory.push(patient);
    }

    public void displayHistory() {

        if (treatmentHistory.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("===== TREATMENT HISTORY =====");

        for (int i = treatmentHistory.size() - 1; i >= 0; i--) {

            Patient patient = treatmentHistory.get(i);

            System.out.println(
                "ID: " + patient.patientId +
                " | Name: " + patient.patientName +
                " | Condition: " + patient.medicalCondition
            );
        }
    }
}