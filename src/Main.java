package src;

public class Main {

    public static void main(String[] args) {

        // =========================
        // PATIENT RECORDS - BST
        // =========================

        PatientBST var1 = new PatientBST();

        Patient p101 = new Patient(101, "Kamal", 25,
                "0771234567", "Fever");

        Patient p105 = new Patient(105, "Nimal", 40,
                "0712345678", "Heart Pain");

        Patient p103 = new Patient(103, "Saman", 30,
                "0763456789", "Injury");

        Patient p102 = new Patient(102, "Amal", 50,
                "0754567890", "Diabetes");

        Patient p108 = new Patient(108, "Sunil", 35,
                "0745678901", "Fever");

        var1.insert(p101);
        var1.insert(p105);
        var1.insert(p103);
        var1.insert(p102);
        var1.insert(p108);

        System.out.println("===== PATIENT RECORDS =====");
        var1.displayInOrder();


        // =========================
        // DELETE PATIENT
        // =========================

        System.out.println("\n===== DELETE PATIENT 105 =====");

        var1.delete(105);

        System.out.println("\n===== PATIENT RECORDS AFTER DELETE =====");

        var1.displayInOrder();


        // =========================
        // SEARCH PATIENT
        // =========================

        System.out.println("\n===== SEARCH PATIENT 103 =====");

        Patient foundPatient = var1.search(103);

        if (foundPatient != null) {
            foundPatient.displayPatient();
        } else {
            System.out.println("Patient not found.");
        }


        // =========================
        // EMERGENCY QUEUE
        // =========================

        EmergencyQueue queue = new EmergencyQueue();

        Patient p201 = new Patient(201, "Ravi", 45,
                "0771111111", "Severe Chest Pain");

        Patient p202 = new Patient(202, "Fathima", 32,
                "0772222222", "Accident Injury");

        Patient p203 = new Patient(203, "Kumar", 60,
                "0773333333", "Breathing Problem");

        System.out.println("\n===== ADD EMERGENCY PATIENTS =====");

        queue.addPatient(p201);
        queue.addPatient(p202);
        queue.addPatient(p203);

        queue.displayQueue();


        // =========================
        // TREATMENT HISTORY - STACK
        // =========================

        TreatmentHistory history = new TreatmentHistory();

        // Treat first patient
        System.out.println("\n===== TREAT FIRST PATIENT =====");

        Patient treatedPatient = queue.treatNextPatient();

        if (treatedPatient != null) {
            history.addToHistory(treatedPatient);
        }


        // Treat second patient
        System.out.println("\n===== TREAT SECOND PATIENT =====");

        treatedPatient = queue.treatNextPatient();

        if (treatedPatient != null) {
            history.addToHistory(treatedPatient);
        }


        // Treat third patient
        System.out.println("\n===== TREAT THIRD PATIENT =====");

        treatedPatient = queue.treatNextPatient();

        if (treatedPatient != null) {
            history.addToHistory(treatedPatient);
        }


        // =========================
        // QUEUE AFTER TREATMENT
        // =========================

        System.out.println("\n===== QUEUE AFTER TREATMENT =====");

        queue.displayQueue();


        // =========================
        // TREATMENT HISTORY
        // =========================

        System.out.println("\n===== TREATMENT HISTORY =====");

        history.displayHistory();


        // =========================
        // PATIENT VISIT HISTORY - LINKED LIST
        // =========================

        PatientVisitHistory visitHistory = new PatientVisitHistory();

        System.out.println("\n===== ADD PATIENT VISITS =====");

        Visit v1 = new Visit(1, "2026-08-01", "Dr. Silva",
                "Fever", "Medication");

        Visit v2 = new Visit(2, "2026-08-15", "Dr. Perera",
                "Injury", "Bandage");

        Visit v3 = new Visit(3, "2026-09-01", "Dr. Fernando",
                "Diabetes", "Blood Test");

        visitHistory.addVisit(v1);
        visitHistory.addVisit(v2);
        visitHistory.addVisit(v3);

        visitHistory.displayVisits();


        // =========================
        // SEARCH VISIT
        // =========================

        System.out.println("\n===== SEARCH VISIT 2 =====");

        visitHistory.searchVisit(2);


        // =========================
        // REMOVE VISIT
        // =========================

        System.out.println("\n===== REMOVE VISIT 1 =====");

        visitHistory.removeVisit(1);


        // =========================
        // VISIT HISTORY AFTER REMOVE
        // =========================

        System.out.println("\n===== VISIT HISTORY AFTER REMOVE =====");

        visitHistory.displayVisits();

    }
}