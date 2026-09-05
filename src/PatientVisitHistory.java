package src;

public class PatientVisitHistory {

    Visit head;

    public void addVisit(Visit visit) {

        if (head == null) {
            head = visit;
            return;
        }

        Visit current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = visit;
    }

    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit " + visitId + " removed.");
            return;
        }

        Visit current = head;

        while (current.next != null) {

            if (current.next.visitId == visitId) {
                current.next = current.next.next;
                System.out.println("Visit " + visitId + " removed.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit " + visitId + " not found.");
    }

    public void searchVisit(int visitId) {

        Visit current = head;

        while (current != null) {

            if (current.visitId == visitId) {
                System.out.println("Visit found:");
                current.displayVisit();
                return;
            }

            current = current.next;
        }

        System.out.println("Visit " + visitId + " not found.");
    }

    public void displayVisits() {

        if (head == null) {
            System.out.println("No previous visits.");
            return;
        }

        System.out.println("===== PATIENT VISIT HISTORY =====");

        Visit current = head;

        while (current != null) {
            current.displayVisit();
            current = current.next;
        }
    }
}