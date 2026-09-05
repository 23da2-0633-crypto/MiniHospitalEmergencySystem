package src;

public class HospitalSystem {

    public static void main(String[] args) {

        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack treatmentHistory = new TreatmentStack();
        PatientVisitHistory visitHistory = new PatientVisitHistory();

        Patient p1 = new Patient(101, "Amal", 30, "0771234567", "Asthma");
        Patient p2 = new Patient(102, "Sara", 25, "0772345678", "Fever");
        Patient p3 = new Patient(103, "John", 40, "0773456789", "Heart Problem");
        Patient p4 = new Patient(104, "Nimal", 35, "0774567890", "Injury");
        Patient p5 = new Patient(105, "Aisha", 28, "0775678901", "Headache");

        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);
        bst.insert(p4);
        bst.insert(p5);

        System.out.println("===== PATIENT RECORDS =====");
        bst.displayInOrder();

        System.out.println("\n===== SEARCH PATIENT 103 =====");

        Patient found = bst.search(103);

        if (found != null) {
            System.out.println(
                "Patient Found: ID: " + found.patientId +
                " | Name: " + found.patientName +
                " | Age: " + found.age +
                " | Condition: " + found.medicalCondition
            );
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\n===== DELETE PATIENT 105 =====");

        bst.delete(105);

        System.out.println("\n===== PATIENT RECORDS AFTER DELETE =====");
        bst.displayInOrder();

        System.out.println("\n===== ADD PATIENTS TO EMERGENCY QUEUE =====");

        queue.addPatient(p3);
        queue.addPatient(p1);
        queue.addPatient(p4);

        System.out.println("\n===== CURRENT EMERGENCY QUEUE =====");
        queue.displayQueue();

        System.out.println("\n===== TREAT NEXT PATIENT =====");

        Patient treatedPatient = queue.treatNextPatient();

        if (treatedPatient != null) {
            treatmentHistory.addTreatment(treatedPatient);
        }

        System.out.println("\n===== QUEUE AFTER TREATMENT =====");
        queue.displayQueue();

        System.out.println("\n===== TREAT NEXT PATIENT =====");

        treatedPatient = queue.treatNextPatient();

        if (treatedPatient != null) {
            treatmentHistory.addTreatment(treatedPatient);
        }

        System.out.println("\n===== QUEUE AFTER TREATMENT =====");
        queue.displayQueue();

        System.out.println("\n===== TREATMENT HISTORY =====");
        treatmentHistory.displayHistory();

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        Visit v1 = new Visit(
            1,
            "2026-08-01",
            "Dr. Perera",
            "Asthma",
            "Inhaler prescribed"
        );

        Visit v2 = new Visit(
            2,
            "2026-08-15",
            "Dr. Silva",
            "Fever",
            "Medicine prescribed"
        );

        Visit v3 = new Visit(
            3,
            "2026-09-01",
            "Dr. Fernando",
            "Breathing Problem",
            "Treatment completed"
        );

        visitHistory.addVisit(v1);
        visitHistory.addVisit(v2);
        visitHistory.addVisit(v3);

        visitHistory.displayVisits();

        System.out.println("\n===== SEARCH VISIT 2 =====");

        visitHistory.searchVisit(2);

        System.out.println("\n===== REMOVE VISIT 1 =====");

        visitHistory.removeVisit(1);

        System.out.println("\n===== VISIT HISTORY AFTER REMOVAL =====");

        visitHistory.displayVisits();
    }
}