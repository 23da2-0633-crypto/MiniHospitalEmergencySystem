package src;

public class PatientBST {

    class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    public void insert(Patient patient) {
        root = insertPatient(root, patient);
    }

    private Node insertPatient(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }

        if (patient.patientId < root.patient.patientId) {
            root.left = insertPatient(root.left, patient);
        } else if (patient.patientId > root.patient.patientId) {
            root.right = insertPatient(root.right, patient);
        }

        return root;
    }

    public void displayInOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);

            System.out.println(
                "ID: " + root.patient.patientId +
                " | Name: " + root.patient.patientName +
                " | Age: " + root.patient.age +
                " | Condition: " + root.patient.medicalCondition
            );

            inOrder(root.right);
        }
    }

    public void delete(int patientId) {
        root = deletePatient(root, patientId);
    }

    private Node deletePatient(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        if (patientId < root.patient.patientId) {
            root.left = deletePatient(root.left, patientId);
        } else if (patientId > root.patient.patientId) {
            root.right = deletePatient(root.right, patientId);
        } else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = findMinimum(root.right);
            root.patient = successor.patient;
            root.right = deletePatient(
                root.right,
                successor.patient.patientId
            );
        }

        return root;
    }

    private Node findMinimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public Patient search(int patientId) {
    Node result = searchPatient(root, patientId);

    if (result != null) {
        return result.patient;
    }

    return null;
}

private Node searchPatient(Node root, int patientId) {

    if (root == null || root.patient.patientId == patientId) {
        return root;
    }

    if (patientId < root.patient.patientId) {
        return searchPatient(root.left, patientId);
    }

    return searchPatient(root.right, patientId);
}
}
