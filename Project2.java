package gr.aueb.cf.javaProjects;

public class Project2 {
        public static void main(String[] args) {
            int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            // Αρχικοποιούμε 2 μεταβλητές, το localMax, globalMax με την πρώτη τιμή του πίνακα
            int localMax = arr[0];
            int globalMax = arr[0];

            // Ξεκινάμε από τη θέση arr[1] του πίνακα και για κάθε θέση
            for (int i = 1; i < arr.length; i++) {
                // εξετάζουμε αν μας συμφέρει να κρατήσουμε το μέχρι τώρα υπολογισμένο
                //  sum ή να ξεκινήσουμε ένα νέο sum  απο τη θέση που βρισκόμαστε
                localMax = Math.max(arr[i], localMax + arr[i]);

                // Αν το νέο localMax είναι μεγαλύτερο από το globalMax, το ενημερώνουμε
                if (localMax > globalMax) {
                    globalMax = localMax;
                }
            }
            // Τυπώνουμε το αποτέλεσμα
            System.out.println("Το μέγιστο άθροισμα συνεχόμενου υποπίνακα είναι: " + globalMax);

        }

}

        // Η πολυπλοκότητα του αλγορίθμου είναι O(n), καθώς κάνουμε μία μόνο διαδρομή στον πίνακα
        // με μήκος n. Σε κάθε βήμα, πραγματοποιούμε σταθερού χρόνου υπολογισμούς (συγκρίσεις και προσθέσεις),
        // και η διαδικασία δεν επαναλαμβάνεται για κανένα στοιχείο.
